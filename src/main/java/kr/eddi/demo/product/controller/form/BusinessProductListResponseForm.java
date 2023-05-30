package kr.eddi.demo.product.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessProductListResponseForm {
    final String productName;
    final Integer productPrice;
    final String productInfo;
    final String imageResourcePath;

}
