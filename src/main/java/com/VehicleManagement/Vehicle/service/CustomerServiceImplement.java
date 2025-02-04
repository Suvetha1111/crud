package com.VehicleManagement.Vehicle.service;

import com.VehicleManagement.Vehicle.model.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CustomerServiceImplement  {

    public Customer saveCustomer(Customer customer);
    public List<Customer> findAllCustomer();
    public Customer findCustomerByID(Long id);
    public Customer updateCustomer(Customer updatedCustomer,Long id );


}
