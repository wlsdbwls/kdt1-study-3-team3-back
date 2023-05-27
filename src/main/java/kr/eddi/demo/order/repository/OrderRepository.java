package kr.eddi.demo.order.repository;

import kr.eddi.demo.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
