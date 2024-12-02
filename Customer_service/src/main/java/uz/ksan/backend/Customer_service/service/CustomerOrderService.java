package uz.ksan.backend.Customer_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.ksan.backend.Customer_service.model.OrderEntity;

import java.util.List;

@FeignClient(name = "customer-order-feignClient-service", url = "http://localhost:8200/api/v1/order/")
public interface CustomerOrderService {

    @GetMapping("{orderCustomerEmail}")
    List<OrderEntity> getCustomerOrders(@PathVariable("orderCustomerEmail") String orderCustomerEmail);

}
