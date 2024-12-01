package uz.ksan.backend.Customer_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.Customer_service.exceptions.NotFoundException;
import uz.ksan.backend.Customer_service.model.CustomerEntity;
import uz.ksan.backend.Customer_service.model.FullCustomerResponse;
import uz.ksan.backend.Customer_service.model.OrderEntity;
import uz.ksan.backend.Customer_service.repository.CustomerRepository;
import uz.ksan.backend.Customer_service.service.CustomerOrderService;
import uz.ksan.backend.Customer_service.service.CustomerService;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
@Primary
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerOrderService customerOrderService;

    public FullCustomerResponse getFullCustomerResponseByEmail(String customerEmail) {
        CustomerEntity customerEntity = customerRepository.findCustomerByCustomerEmail(customerEmail)
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        List<OrderEntity> orders = customerOrderService.getCustomerOrders(customerEntity.getCustomerId());

        FullCustomerResponse fullCustomerResponse = new FullCustomerResponse();
        fullCustomerResponse.setCustomerId(customerEntity.getCustomerId());
        fullCustomerResponse.setCustomerFullName(customerEntity.getCustomerFullName());
        fullCustomerResponse.setCustomerEmail(customerEntity.getCustomerEmail());
        fullCustomerResponse.setCustomerPhone(customerEntity.getCustomerPhone());
        fullCustomerResponse.setCustomerDistrict(customerEntity.getCustomerDistrict());
        fullCustomerResponse.setOrders(orders);

        return fullCustomerResponse;
    }


    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }


    public Optional<CustomerEntity> findCustomerByCustomerEmail(String customerEmail) {
        return Optional.ofNullable(customerRepository.findCustomerByCustomerEmail(customerEmail)
                .orElseThrow(() -> new uz.ksan.backend.Customer_service.exceptions.NotFoundException("Customer with email " + customerEmail + " not found")));
    }

    public Long findIdByCustomerEmail(String customerEmail) {
        return customerRepository.findIdByCustomerEmail(customerEmail);
    }


    @Override
    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
        Long tempId = findIdByCustomerEmail(customerEntity.getCustomerEmail());
        if (findCustomerByCustomerEmail(customerEntity.getCustomerEmail()).isPresent()) {
            customerRepository.delete(customerEntity);
        }
        customerEntity.setCustomerId(tempId);
        return customerRepository.save(customerEntity);
    }

    @Override
    public void deleteCustomerByCustomerEmail(String customerEmail) {
        var findCustomer = customerRepository.findCustomerByCustomerEmail(customerEmail)
                .orElseThrow(() -> new uz.ksan.backend.Customer_service.exceptions.
                        NotFoundException("Customer with email " + customerEmail + " not found"));
        customerRepository.delete(findCustomer);
    }


}
