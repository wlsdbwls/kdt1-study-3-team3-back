package kr.eddi.demo.order.controller.form;

import kr.eddi.demo.order.service.request.OrderRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderRegisterRequestForm {

    final private Long productId;
    final private String userToken;

    public OrderRegisterRequest toOrderRegisterRequest() {
        return new OrderRegisterRequest(productId);
    }
}
