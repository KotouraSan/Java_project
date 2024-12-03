package uz.ksan.backend.Delivery_serivce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

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
    Boolean deliveryShippedStatus = false;
    String deliveryShopAddress;
    String deliveryClientAddress;
    LocalDateTime deliveryTimeStart = LocalDateTime.now();
    LocalDateTime deliveryTimeEnd = LocalDateTime.now().plusMinutes(1);
    Long seconds;
    UUID deliveryOrderId;

}
