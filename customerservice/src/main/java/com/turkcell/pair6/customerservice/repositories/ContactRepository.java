package com.turkcell.pair6.customerservice.repositories;

import com.turkcell.pair6.customerservice.entities.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Contact c SET c.isActive = false WHERE c.id = :contactId")
    void deactivateByContactId(@Param("contactId") int contactId);

}
