package kr.eddi.demo.product.service.request;

import kr.eddi.demo.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequest {

    final private String productName;
    final private Integer productPrice;
    final private String productInfo;

    public Product toProduct() {
        return new Product(productName, productPrice, productInfo);
    }
}

