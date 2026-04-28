package com.AutoServix.AutoServix.Repository;
import java.util.Optional;


import com.AutoServix.AutoServix.Models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerModel , Integer> {
    Optional<CustomerModel> findByEmail(String email);
}
