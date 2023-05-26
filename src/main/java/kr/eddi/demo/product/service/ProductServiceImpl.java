package kr.eddi.demo.product.service;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.entity.ProductImages;
import kr.eddi.demo.product.repository.ProductImagesRepository;
import kr.eddi.demo.product.repository.ProductRepository;
import kr.eddi.demo.product.service.request.ProductRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final private ProductRepository productRepository;
    final private ProductImagesRepository productImagesRepository;

    @Override
    public Product read(Long id){
        Optional<Product> maybeProduct = productRepository.findById(id);

        if (maybeProduct.isEmpty()) {
            log.info("존재하지 않는 상품id입니다.");
            return null;
        }
        return maybeProduct.get();
    }

    @Override
    public Boolean register(ProductRegisterRequest request, List<MultipartFile> productImg) {

        final List<ProductImages> productImagesList = new ArrayList<>();
        final String fixedDirectoryPath = "../kdt1-study-3-team3-front/src/assets/uploadImgs/";

        Product product = request.toProduct();

        try {
            for (MultipartFile multipartFile: productImg) {
                final String originalFileName = multipartFile.getOriginalFilename();
                final String uniqueRandomFileName = UUID.randomUUID() + originalFileName;
                final String fullPath = fixedDirectoryPath + uniqueRandomFileName;
                final FileOutputStream writer = new FileOutputStream(fullPath);

                log.info("originalFileName: " + originalFileName);

                writer.write(multipartFile.getBytes());
                writer.close();

                ProductImages productImages = new ProductImages(uniqueRandomFileName);
                productImagesList.add(productImages);

                product.setProductImages(productImages);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        productRepository.save(product);
        productImagesRepository.saveAll(productImagesList);

        return true;
    }
        // 등록할 수 있는 사람이면 상품을 등록하도록

}
