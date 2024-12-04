package uz.ksan.backend.Customer_service.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;

    @Column(name = "customerFullName")
    @ColumnTransformer(write = "LOWER(?)")
    String customerFullName;
    @Column(name = "customerEmail")
    @ColumnTransformer(write = "LOWER(?)")
    String customerEmail;
    String customerPhone;
    @Column(name = "customerDistrict")
    Integer customerDistrict;

}
