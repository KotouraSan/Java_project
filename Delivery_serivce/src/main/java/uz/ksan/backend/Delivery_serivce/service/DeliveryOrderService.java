package uz.ksan.backend.Delivery_serivce.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.ksan.backend.Delivery_serivce.model.OrderEntity;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "delivery-order-feignClient-service", url = "http://localhost:8200/api/v1/order/")
public interface DeliveryOrderService {

    @GetMapping("id/{orderId}")
    List<OrderEntity> getOrderByOrderId(@PathVariable("orderId") UUID orderId);
}
