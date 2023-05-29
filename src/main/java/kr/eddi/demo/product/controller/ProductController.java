package kr.eddi.demo.product.controller;

import kr.eddi.demo.account.service.AccountService;
import kr.eddi.demo.product.controller.form.ProductListResponseForm;
import kr.eddi.demo.product.controller.form.ProductReadResponseForm;
import kr.eddi.demo.product.controller.form.ProductRegisterRequestForm;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.service.request.ProductRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import kr.eddi.demo.product.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static kr.eddi.demo.account.entity.RoleType.BUSINESS;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;
    final private AccountService accountService;

    @GetMapping("/{id}")
    public ProductReadResponseForm readProduct(@PathVariable("id") Long id) {
        log.info("readProduct()");
        return productService.read(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        log.info("deleteProduct()");
        productService.delete(id);}

    @PostMapping(value = "/register",
    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public Boolean registerProduct(@RequestPart(value = "aboutProduct") ProductRegisterRequestForm registerRequestForm,
                                   @RequestPart(value = "productImg") List<MultipartFile> productImg) {

        log.info("registerProduct()");
        if (accountService.lookup(registerRequestForm.getUserToken()) != BUSINESS) {
            return false;
        }

        return productService.register(registerRequestForm.toProductRegisterRequest(), productImg);
    }
    @PostMapping("/list")
    public List<ProductListResponseForm> list (){
        List<ProductListResponseForm> returnList;
        returnList=productService.list();
        return returnList;
    }

    @PutMapping("/{id}")
    public Product modifyProduct (@PathVariable("id") Long id,
                                  @RequestBody ProductRegisterRequest requestForm) {
        log.info("modifyProduct(): "+  requestForm);
        log.info("id:" + id);

        return productService.modify(id, requestForm);
    }
}
