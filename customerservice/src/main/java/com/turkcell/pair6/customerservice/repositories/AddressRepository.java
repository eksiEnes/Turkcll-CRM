package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCustomerIdAndIsprimaryTrue(int customerId);



    @Query("SELECT a FROM Address a WHERE a.customer.id = :customerId AND a.isPrimary = true")
    Optional<Address> findPrimaryAddressesByCustomerId(@Param("customerId") int customerId);


    @Modifying
    @Transactional
    @Query("UPDATE Address a SET a.isActive = false WHERE a.id = :addressId AND a.isPrimary = false")
    void deactivateByAddressId(@Param("addressId") int addressId);
}
