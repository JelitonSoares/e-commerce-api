package com.zex.ecommerce.controllers;

import com.zex.ecommerce.domain.product.*;
import com.zex.ecommerce.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @Operation(summary = "Create a product")
    public ResponseEntity<DetailsProductDTO> create(@RequestBody @Valid CreateProductDTO data, UriComponentsBuilder componentsBuilder) {
        DetailsProductDTO dto = this.service.create(data);

        URI uri = componentsBuilder.path("/ecommerce/products/{id}").buildAndExpand(dto.id()).toUri();


        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(dto);
    }


    @GetMapping
    @Operation(summary = "List all products")
    public ResponseEntity<PagedModel<SimplifiedProductDTO>> getAll(@PageableDefault(size = 10, sort = {"category"}) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel(this.service.getAll(pageable)));
    }

    @PutMapping
    @Operation(summary = "Updates a product by ID")
    public ResponseEntity<DetailsProductDTO> update(@RequestBody @Valid UpdateProductDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(data));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product by ID")
    public ResponseEntity delete(@PathVariable String id) {
        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Details a product by ID")
    public ResponseEntity<DetailsProductDTO> details(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.details(id));
    }



    @GetMapping("/name/{name}")
    @Operation(summary = "Find a product by name")
    public ResponseEntity<PagedModel<SimplifiedProductDTO>> findByName(@PathVariable String name, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(this.service.findByName(name, pageable)));
    }



    @GetMapping("/category/{category}")
    @Operation(summary = "Find a product by category")
    public ResponseEntity<PagedModel<SimplifiedProductDTO>> findByCategory(@PathVariable  String category, Pageable pageable) {
        Category productCategory = Category.valueOf(category.toUpperCase());
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(this.service.findByCategory(productCategory, pageable)));
    }







}
