package com.zex.ecommerce.controllers;

import com.zex.ecommerce.dtos.client.CreateClientDTO;
import com.zex.ecommerce.dtos.client.DetailsClientDTO;
import com.zex.ecommerce.dtos.client.UpdateClientDTO;
import com.zex.ecommerce.models.client.Client;
import com.zex.ecommerce.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ecommerce/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<DetailsClientDTO> create(@RequestBody @Valid CreateClientDTO data, UriComponentsBuilder builder) {
        DetailsClientDTO client = this.service.create(data);


        URI uri = builder.path("/ecommerce/clients/{id}").buildAndExpand(client.id()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(client);
    }


    @GetMapping
    public ResponseEntity<List<CreateClientDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.findAll());
    }

    @PutMapping
    public ResponseEntity<CreateClientDTO> update(@RequestBody UpdateClientDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(data));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        this.service.delete(id);
    }
}
