package uz.ksan.backend.Order_service.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    UUID orderId = UUID.randomUUID();
    String orderCustomerEmail;
    Integer orderShippingAddress;
    Integer orderShopAddress;

}
