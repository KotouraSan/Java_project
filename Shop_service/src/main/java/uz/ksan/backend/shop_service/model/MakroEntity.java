package uz.ksan.backend.shop_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.ksan.backend.shop_service.repository.ProductInterface;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MakroEntity implements Serializable, ProductInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String productName;
    String productDescription;
    Double productPrice;
    Integer stock;
    String productUrl;

}
