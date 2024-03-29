package com.turkcell.pair6.customerservice.services.abstracts;

import com.turkcell.pair6.customerservice.entities.Contact;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddContactRequest;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAll();

    void delete(int id);

    Optional<Contact> getById(int id);

    void add(AddContactRequest request);
}
