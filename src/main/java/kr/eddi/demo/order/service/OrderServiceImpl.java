package kr.eddi.demo.order.service;

import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.entity.Role;
import kr.eddi.demo.account.repository.AccountRepository;
import kr.eddi.demo.account.repository.AccountRoleRepository;
import kr.eddi.demo.account.repository.UserTokenRepository;
import kr.eddi.demo.account.repository.UserTokenRepositoryImpl;
import kr.eddi.demo.order.controller.form.OrderResponseForm;
import kr.eddi.demo.order.entity.Orders;
import kr.eddi.demo.order.repository.OrderRepository;
import kr.eddi.demo.order.service.request.OrderRegisterRequest;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.entity.ProductImages;
import kr.eddi.demo.product.repository.ProductImagesRepository;
import kr.eddi.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import static kr.eddi.demo.account.entity.RoleType.NORMAL;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    final private OrderRepository orderRepository;
    final private AccountRepository accountRepository;
    final private AccountRoleRepository accountRoleRepository;
    final private ProductRepository productRepository;

    final private ProductImagesRepository productImagesRepository;

    @Override
    public Boolean register(Long accountId, OrderRegisterRequest orderRegisterRequest) {
        final Optional<Account> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isEmpty()) {
            return null;
        }

        final Account account = maybeAccount.get();
        final Role role = accountRoleRepository.findRoleByAccount(account);

        if (role.getRoleType() != NORMAL) {
            return null;
        }

        final Optional<Product> maybeProduct = productRepository.findById(orderRegisterRequest.getProductId());

        if (maybeProduct.isEmpty()) {
            return null;
        }

        final Orders orders = new Orders(maybeProduct.get(), account);
        orderRepository.save(orders);

        return true;
    }

    @Override
    public List<OrderResponseForm> orderList(Long accountId) {
        final List<Object[]> ordersList = orderRepository.findAllProductInfoByAccount(accountId);
        final List<OrderResponseForm> responseFormList = new ArrayList<>();

        for (Object[] row : ordersList) {
            Long productId = (Long) row[0];
            String productInfo = (String) row[1];
            String productName = (String) row[2];
            Integer productPrice = (Integer) row[3];

            final List<ProductImages> productImagesList =
                    productImagesRepository.findImagePathByProductId(productId);

            for (ProductImages imagesPath : productImagesList) {
                imagesPath.getImageResourcePath();
            }

            System.out.println("Product ID: " + productId);
            System.out.println("Product Info: " + productInfo);
            System.out.println("Product Name: " + productName);
            System.out.println("Product Price: " + productPrice);
            System.out.println("------------------------");

            responseFormList.add(new OrderResponseForm(
                    productId, productName, productPrice, productInfo, ));
        }

        return responseFormList;
    }
}
