package br.com.fiap.ordercrud.controller;

import br.com.fiap.ordercrud.core.domain.dto.OrderDto;
import br.com.fiap.ordercrud.core.service.ConsultCommand;
import br.com.fiap.ordercrud.core.service.InsertCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ConsultCommand consultCommand;

    @Autowired
    private InsertCommand insertCommand;


    @PostMapping
    @Transactional
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto order, UriComponentsBuilder uriBuilder) {
        OrderDto savedOrder = insertCommand.create(order);

        URI uri = uriBuilder.path("/order/{id}").buildAndExpand(savedOrder.getId()).toUri();
        return ResponseEntity.created(uri).body(savedOrder);
    }

    @GetMapping
    public  ResponseEntity<?> findAll() {
        List<OrderDto> response = consultCommand.findAll();

        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable(required = true, value = "id") Integer id) {
        OrderDto response = consultCommand.detail(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable(required = true, value = "id") Integer id) {
        boolean response = insertCommand.delete(id);

        if (!response) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@PathVariable(required = true, value = "id") Integer id, @RequestBody OrderDto order) {
        OrderDto response = insertCommand.update(id, order);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

}
