package com.VehicleManagement.Vehicle.repository;

import com.VehicleManagement.Vehicle.model.Role;
import com.VehicleManagement.Vehicle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String username);

    User findByRole(Role role);
}
