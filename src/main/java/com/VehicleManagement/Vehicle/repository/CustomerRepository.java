package com.VehicleManagement.Vehicle.repository;

import com.VehicleManagement.Vehicle.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



}
