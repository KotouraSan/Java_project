package uz.ksan.backend.Order_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.Order_service.model.OrderEntity;
import uz.ksan.backend.Order_service.repository.OrderRepository;
import uz.ksan.backend.Order_service.service.OrderSerivce;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class OrderServiceImpl implements OrderSerivce {

    OrderRepository orderRepository;

    @Override
    public String saveOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
        return "Order saved";
    }

    @Override
    public void deleteOrderByOrderId(UUID orderId) {
        var findOrder = orderRepository.findByOrderId(orderId);
        orderRepository.delete(findOrder);
    }

    public List<OrderEntity> getOrderByCustomerId(Long orderCustomerId) {
        return orderRepository.findByOrderCustomerId(orderCustomerId);
    }
}
