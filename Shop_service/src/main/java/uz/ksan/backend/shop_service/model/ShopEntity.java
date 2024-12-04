package uz.ksan.backend.shop_service.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long shopId;

    @Column(name = "shopName")
    String shopName;
    @Column(name = "shopAddress")
    String shopAddress;
    @Column(name = "shopDistrict")
    Integer shopDistrict;
    @Column(name = "shopCity")
    String shopCity;
    @Column(name = "shopPhoneNumber")
    String shopPhoneNumber;
    @Column(name = "shopEmailAddress")
    String shopEmailAddress;
    Integer shopRating;
}
