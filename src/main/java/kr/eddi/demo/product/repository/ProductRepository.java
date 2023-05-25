package kr.eddi.demo.product.repository;

import kr.eddi.demo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
