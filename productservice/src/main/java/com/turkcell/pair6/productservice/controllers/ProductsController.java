package com.turkcell.pair6.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    @GetMapping("/hasProduct")
    boolean hasAccountProduct(@RequestParam("accountId") int accountId)
    {
        return false;
    }
}