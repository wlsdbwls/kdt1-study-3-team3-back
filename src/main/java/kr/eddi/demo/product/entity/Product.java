package kr.eddi.demo.product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer productPrice;
    private String productInfo;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImages> productImagesList = new ArrayList<>();

    public Product(String productName, Integer productPrice, String productInfo) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
    }

    public void setProductImages(ProductImages productImg) {
        productImg.setProduct(this);
        productImagesList.add(productImg);
    }
}
