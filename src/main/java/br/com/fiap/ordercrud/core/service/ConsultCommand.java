package br.com.fiap.ordercrud.core.service;

import br.com.fiap.ordercrud.core.domain.dto.OrderDto;
import br.com.fiap.ordercrud.core.domain.model.Orders;
import br.com.fiap.ordercrud.mapper.OrderMapper;
import br.com.fiap.ordercrud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultCommand {

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderMapper mapper;

    public List<OrderDto> findAll() {
        List<Orders> ordersFound = repository.findAll();

        List<OrderDto> orders = new ArrayList<>();

        ordersFound.stream().forEach(product -> {
            orders.add(mapper.toDto(product));
        });

        return orders;
    }

    public OrderDto detail(Integer id) {
        Optional<Orders> found = repository.findById(id);

        if (found.isEmpty()) {
            return null;
        }

        OrderDto order = mapper.toDto(found.get());

        return order;
    }


}
