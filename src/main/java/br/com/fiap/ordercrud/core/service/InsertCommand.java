package br.com.fiap.ordercrud.core.service;

import br.com.fiap.ordercrud.core.domain.dto.OrderDto;
import br.com.fiap.ordercrud.core.domain.model.Orders;
import br.com.fiap.ordercrud.mapper.OrderMapper;
import br.com.fiap.ordercrud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class InsertCommand {

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderMapper mapper;

    public OrderDto create(OrderDto order) {
        Orders orderToSave = Orders.builder()
                .customerCode(order.getCustomerCode())
                .orderDate(Instant.now())
                .totalValue(order.getTotalValue())
                .createdAt(Instant.now())
                .build();

        repository.save(orderToSave);

        return mapper.toDto(orderToSave);
    }

    public boolean delete(Integer id) {
        Optional<Orders> found = repository.findById(id);

        if (found.isEmpty()) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    public OrderDto update(Integer id, OrderDto order) {
        Optional<Orders> found = repository.findById(id);

        if (found.isEmpty()) {
            return null;
        }

        order.setId(found.get().getId());

        Orders orderToSave = Orders.builder()
                .id(order.getId())
                .customerCode(order.getCustomerCode())
                .orderDate(order.getOrderDate())
                .totalValue(order.getTotalValue())
                .createdAt(found.get().getCreatedAt())
                .build();

        repository.save(orderToSave);

        return mapper.toDto(orderToSave);
    }
}
