package com.VehicleManagement.Vehicle.service;

import com.VehicleManagement.Vehicle.model.Customer;
import com.VehicleManagement.Vehicle.model.Vehicle;
import com.VehicleManagement.Vehicle.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;


@Service

public class CustomerService implements CustomerServiceImplement{

    @Autowired
    private CustomerRepository customerRepository;


    //To create a new customer(POST)

    public Customer saveCustomer(Customer customer) {

        for (Vehicle vehicle : customer.getVehicleList()) {
            vehicle.setCustomer(customer);
        }

        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer()
    {
        return customerRepository.findAll();
    }

    public Customer findCustomerByID(Long id)
    {
        return customerRepository.findById(id).get();
    }

    public void deleteCustomerByID(Long id)
    {
         customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer updatedCustomer,Long id )
    {
        Customer optionalCustomer = findCustomerByID(id);
        if(optionalCustomer!=null)
        {
            Customer customer=optionalCustomer;
            customer.setFullName(updatedCustomer.getFullName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setCompanyName(updatedCustomer.getCompanyName());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            customer.getVehicleList().clear();
            customer.getVehicleList().addAll(updatedCustomer.getVehicleList());
            for(Vehicle vehicle:updatedCustomer.getVehicleList())
            {
                vehicle.setCustomer(customer);
            }
            return customerRepository.save(customer);
        }
        else {
            throw new RuntimeException("Customer not found with id"+id);
        }
    }
}
