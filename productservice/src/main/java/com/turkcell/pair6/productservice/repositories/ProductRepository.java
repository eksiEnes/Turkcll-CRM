package com.turkcell.pair6.productservice.repositories;

import com.turkcell.pair6.customerservice.entities.IndividualCustomer;
import com.turkcell.pair6.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    void deleteByProductNo(String productNo);

    Optional<Product> findByProductNo(String ProductNo);
}
