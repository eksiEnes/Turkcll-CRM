package com.turkcell.pair6.productservice.repositories;

import com.turkcell.pair6.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    void deleteByProductNo(String productNo);

    @Query("SELECT p FROM Product p WHERE p.productNo = :productNo")
    Product findByProductNo(@Param("productNo") String ProductNo);
}
