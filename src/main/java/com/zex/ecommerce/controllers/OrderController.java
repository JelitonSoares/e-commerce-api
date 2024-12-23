package com.zex.ecommerce.controllers;

import com.zex.ecommerce.domain.client.query.Top5Clients;
import com.zex.ecommerce.domain.client.query.TotalAmountSpentByClients;
import com.zex.ecommerce.domain.order.CreateOrderDTO;
import com.zex.ecommerce.domain.order.DetailsOrderDTO;
import com.zex.ecommerce.domain.order.SimplifiedOrderDTO;
import com.zex.ecommerce.domain.order.UpdateOrderDTO;
import com.zex.ecommerce.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ecommerce/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    @Operation(summary = "Create a Order")
    public ResponseEntity<DetailsOrderDTO> create(@RequestBody @Valid CreateOrderDTO data, UriComponentsBuilder builder) {

        DetailsOrderDTO newOrder = this.service.create(data);

        URI uri = builder.path("/ecommerce/orders/{id}").buildAndExpand(newOrder.id()).toUri();


        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(newOrder);
    }

    @GetMapping
    @Operation(summary = "List all orders")
    public ResponseEntity<PagedModel<SimplifiedOrderDTO>> findAll(@PageableDefault(size = 10, sort = {"orderDate"}, direction = Sort.Direction.DESC ) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<SimplifiedOrderDTO>(this.service.findAll(pageable)));
    }


    @PutMapping
    @Operation(summary = "Updates a order by ID")
    public ResponseEntity<DetailsOrderDTO> update(@RequestBody @Valid UpdateOrderDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(data));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a order by ID")
    public ResponseEntity delete(@PathVariable String id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Details a order by ID")
    public ResponseEntity<DetailsOrderDTO> details(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.details(id));
    }


    @GetMapping("/client/{clientID}")
    @Operation(summary = "Find a order by client")
    public ResponseEntity<PagedModel<DetailsOrderDTO>> findByClient(@PathVariable String clientID, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(this.service.findByClient(clientID, pageable)));
    }


    @GetMapping("/clients/best-buyers")
    @Operation(summary = "Find the top five clients with more orders")
    public ResponseEntity<PagedModel<Top5Clients>> getTop5Clients(@PageableDefault(size = 5)   Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(this.service.getTop5Clients(pageable)));
    }

    @GetMapping("clients/total-spent")
    @Operation(summary = "Returns the total spent by clients")
    public ResponseEntity<PagedModel<TotalAmountSpentByClients>> getTotalSpent(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(this.service.getTotalAmountSpentByClients(pageable)));
    }
}
