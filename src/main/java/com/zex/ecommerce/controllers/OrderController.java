package com.zex.ecommerce.controllers;

import com.zex.ecommerce.domain.order.OrderDTO;
import com.zex.ecommerce.domain.order.CreateOrderDTO;
import com.zex.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(data));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }
}
