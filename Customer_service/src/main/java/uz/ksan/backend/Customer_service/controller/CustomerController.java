package uz.ksan.backend.Customer_service.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.Customer_service.model.CustomerEntity;
import uz.ksan.backend.Customer_service.model.FullCustomerResponse;
import uz.ksan.backend.Customer_service.repository.CustomerRepository;
import uz.ksan.backend.Customer_service.service.CustomerOrderService;
import uz.ksan.backend.Customer_service.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer/")
@FieldDefaults(makeFinal = true)
@Transactional
public class CustomerController {

    CustomerService customerService;
    CustomerRepository customerRepository;
    CustomerOrderService customerOrderService;

    @GetMapping("full/{customerEmail}")
    public FullCustomerResponse getFullCustomerResponse(@PathVariable("customerEmail") String customerEmail) {
        return customerService.getFullCustomerResponseByEmail(customerEmail);
    }

    @PostMapping
    public String saveCustomer(@RequestBody CustomerEntity customerEntity) {
        customerService.saveCustomer(customerEntity);
        return "Customer saved";
    }

    @GetMapping("{customerEmail}")
    public Optional<CustomerEntity> getCustomerByEmail(@PathVariable String customerEmail) {
        return customerRepository.findCustomerByCustomerEmail(customerEmail);
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerEntity customerEntity) {
        customerService.updateCustomer(customerEntity);
        return "Customer updated";
    }

    @DeleteMapping("{customerEmail}")
    public void deleteCustomer(@PathVariable String customerEmail) {
        customerService.deleteCustomerByCustomerEmail(customerEmail);
    }
}
