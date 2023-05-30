package kr.eddi.demo.product.service;

import kr.eddi.demo.product.controller.form.BusinessProductListResponseForm;
import kr.eddi.demo.product.controller.form.ProductListResponseForm;
import kr.eddi.demo.product.controller.form.ProductReadResponseForm;
import kr.eddi.demo.product.service.request.ProductRegisterRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    @Transactional
    ProductReadResponseForm read(Long id);
    void delete(Long id);
    Boolean register(ProductRegisterRequest productRegisterRequest, List<MultipartFile> productImg);

    List<ProductListResponseForm> list();

    List<BusinessProductListResponseForm> businessRegisterProductList(Long accountId);
  
    Product modify(Long productId, ProductRegisterRequest requestForm);
}
