package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.client.ClientDTO;
import com.zex.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecommerce/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(data));
    }
}
