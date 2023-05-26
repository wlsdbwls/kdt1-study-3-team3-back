package kr.eddi.demo.product.controller;

import kr.eddi.demo.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        log.info("deleteProduct()");
        productService.delete(id);}
}
