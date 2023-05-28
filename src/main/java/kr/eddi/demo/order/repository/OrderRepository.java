package kr.eddi.demo.order.repository;

import kr.eddi.demo.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query(value = "SELECT p.id, p.product_info, p.product_name, p.product_price FROM product p " +
            "JOIN orders o ON p.id = o.product_id " +
            "JOIN account a ON o.account_account_id = a.account_id " +
            "WHERE a.account_id = :accountId", nativeQuery = true)
    List<Object[]> findAllProductInfoByAccount(Long accountId);
}
