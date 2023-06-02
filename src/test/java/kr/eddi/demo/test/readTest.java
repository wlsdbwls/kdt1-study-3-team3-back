//package kr.eddi.demo.test;
//
//import kr.eddi.demo.product.entity.ProductImages;
//import kr.eddi.demo.product.service.ProductService;
//import kr.eddi.demo.product.service.request.ProductRegisterRequest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class readTest {
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    @DisplayName("회원이 상품을 등록합니다.")
//    void 사업자가_상품을_등록합니다() throws IOException {
//        final String productName = "바밤바";
//        final Integer productPrice = 1000;
//        final String productInfo = "나는야 바밤바";
//        final String userToken ="";
//        FileInputStream fileInputStream1 = new FileInputStream("src/assets/uploadImgs/testIMG.PNG");
//        FileInputStream fileInputStream2 = new FileInputStream("src/assets/uploadImgs/testIMG2.PNG");
//        MockMultipartFile file = new MockMultipartFile("image",
//                "testIMG.png",
//                "png",
//                fileInputStream1);
//        MockMultipartFile file2 = new MockMultipartFile("image",
//                "testIMG2.png",
//                "png",
//                fileInputStream2);
//        List<MultipartFile> productImg = new ArrayList<>();
//        productImg.add(file);
//        productImg.add(file2);
//
//
//        ProductRegisterRequest Form = new ProductRegisterRequest(productName, productPrice, productInfo, userToken);
//        productService.register(Form, productImg);
//    }
//
//    @Test
//    @DisplayName("상품의 상세정보를 조회합니다.")
//    void 상세페이지_조회() {
//        productService.read(1L);
//    }
//
//    @Test
//    @DisplayName("상품을 삭제합니다.")
//    void 상세페이지에서_상품삭제() {
//        productService.delete(2L);
//    }
//
//    @Test
//    @DisplayName("상품을 수정합니다.")
//    void 상세페이지에서_상품수정() {
//        final String productName = "캔디바";
//        final Integer productPrice = 1200;
//        final String productInfo = "나는야 캔디바";
//        final String userToken ="";
//        ProductRegisterRequest Form = new ProductRegisterRequest(productName, productPrice, productInfo, userToken);
//        productService.modify(2L, Form);
//    }
//}