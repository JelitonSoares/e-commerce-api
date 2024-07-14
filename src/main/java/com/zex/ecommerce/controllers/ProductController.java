package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.ProductDTO;
import com.zex.ecommerce.dtos.UpdateProductDTO;
import com.zex.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(data));
    }


    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid UpdateProductDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(data));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.service.delete(id);
    }



}
