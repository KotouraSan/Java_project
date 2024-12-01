package uz.ksan.backend.Customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.Customer_service.model.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findCustomerByCustomerEmail(String customerEmail);
    Long findIdByCustomerEmail(String customerEmail);

}
