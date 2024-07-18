package com.zex.ecommerce.services;

import com.zex.ecommerce.dtos.client.ClientDTO;
import com.zex.ecommerce.dtos.client.UpdateClientDTO;
import com.zex.ecommerce.models.client.Client;
import com.zex.ecommerce.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {


    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientDTO save(ClientDTO data) {
        Client client = new Client(data);

        return new ClientDTO(this.repository.save(client));
    }


    public List<ClientDTO> findAll() {
        List<Client> clients = this.repository.findAll();

        return clients.stream()
                .map(c -> new ClientDTO(c))
                .collect(Collectors.toList());
    }

    @Transactional
    public ClientDTO update(UpdateClientDTO data) {
        Client client = this.repository.getReferenceById(data.id());

        client.updateClient(data);

        return new ClientDTO(this.repository.save(client));
    }
}
