package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.ProductDTO;
import com.zex.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(data));
    }

}
