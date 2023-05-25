package kr.eddi.demo.product.controller.form;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductReadResponseForm {
    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productInfo;
    final private String productImg;

    public ProductReadResponseForm(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productInfo = product.getProductInfo();
        this.productImg = product.getProductImg();
    }
}
