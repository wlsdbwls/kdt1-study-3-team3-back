package kr.eddi.demo.product.service;

import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.repository.AccountRepository;
import kr.eddi.demo.account.repository.UserTokenRepository;
import kr.eddi.demo.account.repository.UserTokenRepositoryImpl;
import kr.eddi.demo.product.controller.form.BusinessProductListResponseForm;
import kr.eddi.demo.product.controller.form.ProductListResponseForm;
import kr.eddi.demo.product.controller.form.ProductReadResponseForm;
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

    final private AccountRepository accountRepository;

    final private UserTokenRepository userTokenRepository = UserTokenRepositoryImpl.getInstance();
    @Override
    public ProductReadResponseForm read(Long id) {
        final Optional<Product> maybeProduct = productRepository.findById(id);

        if (maybeProduct.isEmpty()) {
            log.info("존재하지 않는 상품id입니다.");
            return null;
        }
        final Product product = maybeProduct.get();
        final List<ProductImages> productImagesList = productImagesRepository.findImagePathByProductId(id);

        log.info("productImagesList: " + productImagesList);

        return new ProductReadResponseForm(product, productImagesList);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    public Boolean register(ProductRegisterRequest request, List<MultipartFile> productImg) {

        final List<ProductImages> productImagesList = new ArrayList<>();
        final String fixedDirectoryPath = "../kdt1-study-3-team3-front/src/assets/uploadImgs/";

        Product product = request.toProduct();
        String userToken = request.getUserToken();
        final Long accountId = userTokenRepository.findAccountIdByUserToken(userToken);
        Optional<Account> maybeAccount = accountRepository.findById(accountId);
        if(maybeAccount.isPresent()) {
            product.setAccount(maybeAccount.get());
        }

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
    @Override
    public List<ProductListResponseForm> list() {
        List<ProductListResponseForm> tmpList=new ArrayList<>();
        List<Product> products=productRepository.findAll();
        for (Product product:products ){
            List<ProductImages> maybeImages=productImagesRepository.findByProductId(product.getId());
            ProductListResponseForm responseForm=new ProductListResponseForm(product, maybeImages.get(0).getImageResourcePath());
            tmpList.add(responseForm);
        }
        return tmpList;
    }

    @Override
    public List<BusinessProductListResponseForm> businessRegisterProductList(Long accountId) {
        List<BusinessProductListResponseForm> businessRegisterProductList = new ArrayList<>();
        List<Product> productList = productRepository.findAllByAccountId(accountId) ;

        for (Product product: productList ){
            List<ProductImages> maybeImages=productImagesRepository.findByProductId(product.getId());
            BusinessProductListResponseForm responseForm = new BusinessProductListResponseForm(product.getProductName(), product.getProductPrice(), product.getProductInfo(), maybeImages.get(0).getImageResourcePath());
            businessRegisterProductList.add(responseForm);
        }
        return businessRegisterProductList;
    }


}