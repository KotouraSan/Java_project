package uz.ksan.backend.Customer_service.service;

import uz.ksan.backend.Customer_service.model.CustomerEntity;
import uz.ksan.backend.Customer_service.model.FullCustomerResponse;

public interface CustomerService {
    void saveCustomer(CustomerEntity customerEntity);
    CustomerEntity updateCustomer(CustomerEntity customerEntity);
    void deleteCustomerByCustomerEmail(String customerEmail);
    FullCustomerResponse getFullCustomerResponseByEmail(String customerEmail);
}
