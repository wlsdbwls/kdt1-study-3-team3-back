package kr.eddi.demo.order.service;

import kr.eddi.demo.order.controller.form.OrderResponseForm;
import kr.eddi.demo.order.service.request.OrderRegisterRequest;

import java.util.List;

public interface OrderService {
    Boolean register(Long accountId, OrderRegisterRequest orderRegisterRequest);

    List<OrderResponseForm> orderList(Long accountId);
}
