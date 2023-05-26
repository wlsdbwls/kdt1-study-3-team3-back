package kr.eddi.demo.product.service;

import kr.eddi.demo.product.entity.Product;

public interface ProductService {
    Product read(Long id);
    void delete(Long id);
}
