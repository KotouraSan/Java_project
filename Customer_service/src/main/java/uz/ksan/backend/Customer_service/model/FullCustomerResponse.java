package uz.ksan.backend.Customer_service.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
    String customerFullName;
    String customerEmail;
    String customerPhone;
    String customerDistrict;

    List<OrderEntity> orders;

}
