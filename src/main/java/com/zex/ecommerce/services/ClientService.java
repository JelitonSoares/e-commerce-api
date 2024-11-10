package com.zex.ecommerce.services;

import com.zex.ecommerce.domain.client.*;
import com.zex.ecommerce.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {


    @Autowired
    private ClientRepository repository;

    @Transactional
    public DetailsClientDTO create(CreateClientDTO data) {
        Client client = new Client(data);

        return new DetailsClientDTO(this.repository.save(client));
    }


    public Page<SimplifiedClientDTO> getAll(Pageable pageable) {
        Page<Client> clients = this.repository.findAll(pageable);

        return clients.map(c -> new SimplifiedClientDTO(c));
    }

    @Transactional
    public DetailsClientDTO update(UpdateClientDTO data) {
        Client client = this.repository.getReferenceById(data.id());

        client.updateClient(data);

        return new DetailsClientDTO(this.repository.save(client));
    }

    @Transactional
    public void delete(String id) {
        Client client = this.repository.getReferenceById(id);

        this.repository.delete(client);
    }

    public Client getReferenceByID(String id) {
        return this.repository.getReferenceById(id);
    }


    public DetailsClientDTO details(String id) {
        Client client = this.getReferenceByID(id);

        return new DetailsClientDTO(client);
    }


    public Page<SimplifiedClientDTO> findClientByName(String name, Pageable pageable) {
        return this.repository.findByNameContainingIgnoreCase(name, pageable)
                .map(c -> new SimplifiedClientDTO(c));
    }


    public SimplifiedClientDTO finByDocument(String document) {
        return new SimplifiedClientDTO(this.repository.findByDocument(document));
    }

}
