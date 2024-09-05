package com.zex.ecommerce.controllers;

import com.zex.ecommerce.domain.order.OrderDTO;
import com.zex.ecommerce.domain.order.CreateOrderDTO;
import com.zex.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ecommerce/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderDTO data, UriComponentsBuilder builder) {

        OrderDTO newOrder = this.service.create(data);

        URI uri = builder.path("/ecommerce/orders/{id}").buildAndExpand(newOrder.id()).toUri();


        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(newOrder);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }
}
