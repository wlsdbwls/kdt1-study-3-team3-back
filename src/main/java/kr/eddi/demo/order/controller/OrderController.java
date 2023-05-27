package kr.eddi.demo.order.controller;

import kr.eddi.demo.account.service.AccountService;
import kr.eddi.demo.order.controller.form.OrderRegisterRequestForm;
import kr.eddi.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    final private OrderService orderService;
    final private AccountService accountService;

    // 상품 구매
    @PostMapping("/register")
    public Boolean orderRegister (@RequestBody OrderRegisterRequestForm requestForm) {
        final Long accountId = accountService.findAccountId(requestForm.getUserToken());

        return orderService.register(accountId, requestForm.toOrderRegisterRequest());
    }

    // 상품 조회
}
