package kr.eddi.demo.product.repository;

import kr.eddi.demo.product.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    @Query("select pi from ProductImages pi join fetch pi.product p where p.id = :productId")
    ProductImages findImagePathByProductId(Long productId);
}