package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.product.CreateProductDTO;
import com.zex.ecommerce.dtos.product.DetailsProductDTO;
import com.zex.ecommerce.dtos.product.UpdateProductDTO;
import com.zex.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<DetailsProductDTO> create(@RequestBody @Valid CreateProductDTO data, UriComponentsBuilder componentsBuilder) {
        DetailsProductDTO dto = this.service.create(data);

        URI uri = componentsBuilder.path("/ecommerce/products/{id}").buildAndExpand(dto.id()).toUri();


        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(dto);
    }


    @GetMapping
    public ResponseEntity<PagedModel<DetailsProductDTO>> getAll(@PageableDefault(size = 10, sort = {"category"}) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel(this.service.getAll(pageable)));
    }

    @PutMapping
    public ResponseEntity<DetailsProductDTO> update(@RequestBody @Valid UpdateProductDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(data));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetailsProductDTO> details(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.details(id));
    }



}
