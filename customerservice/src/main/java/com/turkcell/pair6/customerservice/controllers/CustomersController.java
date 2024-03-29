package com.turkcell.pair6.customerservice.controllers;

import com.turkcell.pair6.customerservice.entities.Customer;
import com.turkcell.pair6.customerservice.services.dtos.requests.*;
import com.turkcell.pair6.customerservice.services.dtos.responses.SearchCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.turkcell.pair6.customerservice.services.abstracts.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PostMapping("search")
    public List<SearchCustomerResponse> search(@RequestBody @Valid SearchCustomerRequest request){
        return customerService.search(request);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCustomerRequest request)
    {
        customerService.add(request);
    }

    @PostMapping("demographic")
    public void add(@RequestBody @Valid AddDemographicRequest request)
    {
        customerService.add(request);
    }

    @DeleteMapping
    public void delete(int id) {
        customerService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        customerService.update(updateCustomerRequest);
    }

}
