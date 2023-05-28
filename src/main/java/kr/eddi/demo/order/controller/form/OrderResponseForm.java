package kr.eddi.demo.order.controller.form;

import kr.eddi.demo.product.entity.ProductImages;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class OrderResponseForm {

    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productInfo;

    final private String productImagePath;
}
