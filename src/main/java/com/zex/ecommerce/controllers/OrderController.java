package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.order.OrderDTO;
import com.zex.ecommerce.dtos.order.create.CreateOrderDTO;
import com.zex.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(data));
    }
}
