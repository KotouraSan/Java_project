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
    @ColumnTransformer(write = "LOWER(?)")
    String shopName;
    @Column(name = "shopAddress")
    @ColumnTransformer(write = "LOWER(?)")
    String shopAddress;
    @Column(name = "shopDistrict")
    @ColumnTransformer(write = "LOWER(?)")
    String shopDistrict;
    @Column(name = "shopCity")
    @ColumnTransformer(write = "LOWER(?)")
    String shopCity;
    @Column(name = "shopPhoneNumber")
    @ColumnTransformer(write = "LOWER(?)")
    String shopPhoneNumber;
    @Column(name = "shopEmailAddress")
    @ColumnTransformer(write = "LOWER(?)")
    String shopEmailAddress;
    Integer shopRating;
}
