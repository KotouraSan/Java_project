package uz.ksan.backend.Delivery_serivce.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullDeliveryResponse implements Serializable {

    Boolean deliveryShippedStatus;
    LocalDateTime deliveryTimeStart;
    LocalDateTime deliveryTimeEnd;
    Long seconds;
    UUID deliveryOrderId;
    Long deliveryPrice;
    List<OrderEntity> orderInfo;
}
