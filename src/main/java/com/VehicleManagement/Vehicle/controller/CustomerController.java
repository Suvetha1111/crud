//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.VehicleManagement.Vehicle.controller;

import com.VehicleManagement.Vehicle.model.Customer;
import com.VehicleManagement.Vehicle.model.User;
import com.VehicleManagement.Vehicle.service.CustomerService;
import java.util.List;

import com.VehicleManagement.Vehicle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerController {
    @Autowired
    private CustomerService customerService;



    public CustomerController() {
    }

    @PostMapping({"/customer"})
    public Customer createCustomer(@RequestBody Customer customer) {
        return this.customerService.saveCustomer(customer);
    }

    @GetMapping({"/customers"})
    public List<Customer> getAllCustomer() {
        return this.customerService.findAllCustomer();
    }

    @GetMapping({"/customers/{id}"})
    public Customer getCustomerByID(@PathVariable("id") Long id) {
        return this.customerService.findCustomerByID(id);
    }

    @DeleteMapping({"/customer/{id}"})
    public void deleteCustomerByID(@PathVariable("id") Long id) {
        this.customerService.deleteCustomerByID(id);
    }

    @PutMapping({"/customers/update/{id}"})
    public Customer updateCustomerByID(@RequestBody Customer customer, @PathVariable("id") Long id) {
        return this.customerService.updateCustomer(customer, id);
    }

}
