package kr.eddi.demo.product.repository;

import kr.eddi.demo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByAccountId(Long accountId);
}
