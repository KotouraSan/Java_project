package uz.ksan.backend.Delivery_serivce.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity implements Serializable {

    UUID orderId;
    Integer orderShippingAddress;
    Integer orderShopAddress;
}
