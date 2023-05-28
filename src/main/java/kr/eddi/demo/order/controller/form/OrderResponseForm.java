package kr.eddi.demo.order.controller.form;

import kr.eddi.demo.product.entity.ProductImages;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderResponseForm {

    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productInfo;
    final private List<String> productImagesPathList = new ArrayList<>();

    public OrderResponseForm(Long id, String productName,
                             Integer productPrice, String productInfo,
                             List<ProductImages> productImagesList) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;

        for (ProductImages images : productImagesList) {
            this.productImagesPathList.add(images.getImageResourcePath());
        }
    }
}

