package uz.ksan.backend.Delivery_serivce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    Boolean deliveryShippedStatus;
    String deliveryShopAddress;
    String deliveryClientAddress;


}
