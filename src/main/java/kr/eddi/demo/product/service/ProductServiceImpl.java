package kr.eddi.demo.product.service;

import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final private ProductRepository productRepository;

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
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
