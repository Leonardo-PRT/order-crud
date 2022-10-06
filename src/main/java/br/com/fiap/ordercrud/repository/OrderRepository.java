package br.com.fiap.ordercrud.repository;

import br.com.fiap.ordercrud.core.domain.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
