package uz.ksan.backend.Customer_service.model;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullCustomerResponse implements Serializable {

    Long customerId;
    @ColumnTransformer(write = "LOWER(?)")
    String customerFullName;
    @ColumnTransformer(write = "LOWER(?)")
    String customerEmail;
    String customerPhone;
    Integer customerDistrict;

    List<OrderEntity> orders;

}
