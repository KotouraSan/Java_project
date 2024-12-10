package uz.ksan.backend.Delivery_serivce.service;

import uz.ksan.backend.Delivery_serivce.model.DeliveryEntity;
import uz.ksan.backend.Delivery_serivce.model.FullDeliveryResponse;

import java.util.UUID;

public interface DeliveryService {
    String saveDeliveryRequest(DeliveryEntity deliveryEntity);
    void deleteDeliveryRequestByDeliveryOrderId(UUID deliveryOrderId);
    DeliveryEntity getDeliveryRequestByDeliveryOrderId(UUID deliveryOrderId);
    FullDeliveryResponse getFullDeliveryResponseByUUID(UUID deliveryOrderId);
}
