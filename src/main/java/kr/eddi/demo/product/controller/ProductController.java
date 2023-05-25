package kr.eddi.demo.product.controller;

import kr.eddi.demo.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.eddi.demo.product.service.ProductService;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    final private ProductService productService;

    @GetMapping("/{id}")
    public Product readProduct(@PathVariable("id") Long id){
        log.info("readProduct()");
        return productService.read(id);
    }
}
