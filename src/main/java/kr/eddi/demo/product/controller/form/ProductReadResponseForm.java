package kr.eddi.demo.product.controller.form;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.entity.ProductImages;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductReadResponseForm {

    final private Long id;
    final private String productName;
    final private Integer productPrice;
    final private String productInfo;
    final private List<String> productImagesPathList = new ArrayList<>();

    public ProductReadResponseForm(Product product, List<ProductImages> productImagesList) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productInfo = product.getProductInfo();

        for (ProductImages images: productImagesList) {
            this.productImagesPathList.add(images.getImageResourcePath());
        }
    }
}
