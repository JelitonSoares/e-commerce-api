package com.zex.ecommerce.controllers;

import com.zex.ecommerce.domain.client.CreateClientDTO;
import com.zex.ecommerce.domain.client.DetailsClientDTO;
import com.zex.ecommerce.domain.client.SimplifiedClientDTO;
import com.zex.ecommerce.domain.client.UpdateClientDTO;
import com.zex.ecommerce.services.ClientService;
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
    public ResponseEntity<PagedModel<SimplifiedClientDTO>> getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(this.service.getAll(pageable)));
    }

    @PutMapping
    public ResponseEntity<DetailsClientDTO> update(@RequestBody @Valid UpdateClientDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.update(data));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        this.service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetailsClientDTO> details(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.details(id));
    }
}
