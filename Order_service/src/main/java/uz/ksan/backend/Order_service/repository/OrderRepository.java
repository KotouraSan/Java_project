package uz.ksan.backend.Order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.Order_service.model.OrderEntity;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(UUID orderId);
    List<OrderEntity> findByOrderCustomerEmail(String orderCustomerEmail);
}
