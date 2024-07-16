package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.client.ClientDTO;
import com.zex.ecommerce.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody @Valid ClientDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(data));
    }


    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }
}
