package uz.ksan.backend.Delivery_serivce.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.Delivery_serivce.model.DeliveryEntity;
import uz.ksan.backend.Delivery_serivce.repository.DeliveryRepository;
import uz.ksan.backend.Delivery_serivce.service.DeliveryService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/delivery/")
@FieldDefaults(makeFinal = true)
@Transactional
public class DeliveryController {

    DeliveryService deliveryService;
    DeliveryRepository deliveryRepository;

    @PostMapping
    public String saveDeliveryRequest(@RequestBody DeliveryEntity deliveryEntity) {
        deliveryService.saveDeliveryRequest(deliveryEntity);
        return "saved";
    }

    @GetMapping("{deliveryOrderId}")
    public DeliveryEntity getDeliveryByOrderId(@PathVariable UUID deliveryOrderId) {
        return deliveryService.getDeliveryRequestByDeliveryOrderId(deliveryOrderId);
    }

    @DeleteMapping("{deliveryOrderId}")
    public String deleteDeliveryByOrderId(@PathVariable UUID deliveryOrderId) {
        deliveryService.deleteDeliveryRequestByDeliveryOrderId(deliveryOrderId);
        return "deleted";
    }
}
