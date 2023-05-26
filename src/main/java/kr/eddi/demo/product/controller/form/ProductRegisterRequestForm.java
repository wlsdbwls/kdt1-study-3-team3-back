package kr.eddi.demo.product.controller.form;

import kr.eddi.demo.product.service.request.ProductRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRegisterRequestForm {

    final private String productName;
    final private Integer productPrice;
    final private String productInfo;
    final private String userToken;
    // 유저토큰 추가하기

    public ProductRegisterRequest toProductRegisterRequest() {
        return new ProductRegisterRequest(productName, productPrice, productInfo);
    }

}
