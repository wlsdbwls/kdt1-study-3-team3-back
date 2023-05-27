package kr.eddi.demo.product.service;

import kr.eddi.demo.product.controller.form.ProductListResponseForm;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.request.ProductRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product read(Long id);
    void delete(Long id);
    Boolean register(ProductRegisterRequest productRegisterRequest, List<MultipartFile> productImg);

    List<ProductListResponseForm> list();
}
