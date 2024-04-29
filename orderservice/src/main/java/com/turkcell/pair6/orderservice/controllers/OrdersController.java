package com.turkcell.pair6.orderservice.controllers;

import com.turkcell.events.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @GetMapping("/hasProduct")
    boolean hasCustomerProduct(@RequestParam("customerNationalityId") String nationalityId)
    {
        return false;
    }

    @PostMapping
    public String addOrder()
    {
        kafkaTemplate.send("orderTopic","NewOrderEvent", new OrderCreatedEvent(1, LocalDateTime.now()));
        return "Sipariş eklendi..";
    }
}
