package com.zex.ecommerce.services;

import com.zex.ecommerce.dtos.client.CreateClientDTO;
import com.zex.ecommerce.dtos.client.DetailsClientDTO;
import com.zex.ecommerce.dtos.client.UpdateClientDTO;
import com.zex.ecommerce.models.client.Client;
import com.zex.ecommerce.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {


    @Autowired
    private ClientRepository repository;

    @Transactional
    public DetailsClientDTO create(CreateClientDTO data) {
        Client client = new Client(data);

        return new DetailsClientDTO(this.repository.save(client));
    }


    public Page<DetailsClientDTO> getAll(Pageable pageable) {
        Page<Client> clients = this.repository.findAll(pageable);

        return clients.map(c -> new DetailsClientDTO(c));
    }

    @Transactional
    public CreateClientDTO update(UpdateClientDTO data) {
        Client client = this.repository.getReferenceById(data.id());

        client.updateClient(data);

        return new CreateClientDTO(this.repository.save(client));
    }

    @Transactional
    public void delete(UUID id) {
        Client client = this.repository.getReferenceById(id);

        this.repository.delete(client);
    }

    public Client getReferenceByID(UUID id) {
        return this.repository.getReferenceById(id);
    }
}
