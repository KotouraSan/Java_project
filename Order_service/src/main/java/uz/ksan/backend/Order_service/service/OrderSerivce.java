package uz.ksan.backend.Order_service.service;

import uz.ksan.backend.Order_service.model.OrderEntity;

import java.util.List;
import java.util.UUID;

public interface OrderSerivce {
    String saveOrder(OrderEntity orderEntity);
    void deleteOrderByOrderId(UUID orderId);
    List<OrderEntity> getOrderByCustomerId(Long orderCustomerId);
}
