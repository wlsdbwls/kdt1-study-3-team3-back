package kr.eddi.demo.order.service;

import kr.eddi.demo.order.service.request.OrderRegisterRequest;

public interface OrderService {
    Boolean register(Long accountId, OrderRegisterRequest orderRegisterRequest);
}
