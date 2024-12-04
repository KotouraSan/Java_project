package uz.ksan.backend.Delivery_serivce.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.Delivery_serivce.exceptions.NotFoundException;
import uz.ksan.backend.Delivery_serivce.model.DeliveryEntity;
import uz.ksan.backend.Delivery_serivce.model.FullDeliveryResponse;
import uz.ksan.backend.Delivery_serivce.model.OrderEntity;
import uz.ksan.backend.Delivery_serivce.repository.DeliveryRepository;
import uz.ksan.backend.Delivery_serivce.service.DeliveryOrderService;
import uz.ksan.backend.Delivery_serivce.service.DeliveryService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class DeliveryServiceImpl implements DeliveryService {

    DeliveryRepository deliveryRepository;
    DeliveryOrderService deliveryOrderService;

    @Override
    public String saveDeliveryRequest(DeliveryEntity deliveryEntity) {
        deliveryRepository.save(deliveryEntity);
        return "Request has been saved";
    }

    @Override
    public void deleteDeliveryRequestByDeliveryOrderId(UUID deliveryOrderId) {
        var foundOrder = deliveryRepository.findByDeliveryOrderId(deliveryOrderId)
                .orElseThrow(() -> new NotFoundException("Delivery order not found"));
        deliveryRepository.delete(foundOrder);
    }

    @Override
    public DeliveryEntity getDeliveryRequestByDeliveryOrderId(UUID deliveryOrderId) {
        var foundOrder = deliveryRepository.findByDeliveryOrderId(deliveryOrderId);
        Long time = ChronoUnit.SECONDS.between(foundOrder.get().getDeliveryTimeStart(), LocalDateTime.now());
        var order = deliveryRepository.findByDeliveryOrderId(deliveryOrderId)
                .orElseThrow(() -> new NotFoundException("Delivery order not found"));
        order.setSeconds(time);
        return order;
    }

    public FullDeliveryResponse getFullDeliveryResponseByUUID(UUID deliveryOrderId) {
        DeliveryEntity deliveryEntity = deliveryRepository.findByDeliveryOrderId(deliveryOrderId)
                .orElseThrow(() -> new NotFoundException("Delivery order not found"));

        List<OrderEntity> deliveryOrders = deliveryOrderService.getOrderByOrderId(deliveryEntity.getDeliveryOrderId());

        FullDeliveryResponse fullDeliveryResponse = new FullDeliveryResponse();
        fullDeliveryResponse.setDeliveryOrderId(deliveryOrderId);
        fullDeliveryResponse.setDeliveryPrice(deliveryEntity.getDeliveryPrice());
        fullDeliveryResponse.setDeliveryTimeEnd(deliveryEntity.getDeliveryTimeEnd());
        fullDeliveryResponse.setDeliveryTimeStart(deliveryEntity.getDeliveryTimeStart());
        fullDeliveryResponse.setOrderInfo(deliveryOrders);
        return fullDeliveryResponse;
    }
}
