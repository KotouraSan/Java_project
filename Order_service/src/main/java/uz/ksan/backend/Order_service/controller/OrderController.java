package uz.ksan.backend.Order_service.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.Order_service.model.OrderEntity;
import uz.ksan.backend.Order_service.repository.OrderRepository;
import uz.ksan.backend.Order_service.service.OrderSerivce;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order/")
@FieldDefaults(makeFinal = true)
@Transactional
public class OrderController {
    OrderSerivce orderService;
    OrderRepository orderRepository;

    @PostMapping
    public String createOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.saveOrder(orderEntity);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable("orderId") UUID orderId) {
        orderService.deleteOrderByOrderId(orderId);
    }

    @GetMapping("{orderCustomerId}")
    public List<OrderEntity> getOrderByCustomerId(@PathVariable("orderCustomerId") Long orderCustomerId) {
        return orderService.getOrderByCustomerId(orderCustomerId);
    }
}
