package com.turkcell.pair6.invoiceservice.repositories;


import com.turkcell.pair6.invoiceservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
