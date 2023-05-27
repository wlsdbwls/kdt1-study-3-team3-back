package kr.eddi.demo.product.controller.form;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductListResponseForm {

    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productInfo;
    final private String productImagePath;

    public ProductListResponseForm(Product product, String productImagePath) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productInfo = product.getProductInfo();
        this.productImagePath = productImagePath;
    }

}
