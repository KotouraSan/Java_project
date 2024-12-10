package uz.ksan.backend.Delivery_serivce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.Delivery_serivce.model.DeliveryEntity;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long>{
    Optional<DeliveryEntity> findByDeliveryOrderId(UUID deliveryOrderId);
}
