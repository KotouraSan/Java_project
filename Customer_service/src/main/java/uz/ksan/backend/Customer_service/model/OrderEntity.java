package uz.ksan.backend.Customer_service.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity implements Serializable {

    UUID orderId;
    String orderShippingAddress;
    Boolean orderShippedStatus;
}
