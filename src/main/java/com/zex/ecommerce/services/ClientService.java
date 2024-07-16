package com.zex.ecommerce.services;

import com.zex.ecommerce.dtos.client.ClientDTO;
import com.zex.ecommerce.models.client.Client;
import com.zex.ecommerce.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientDTO save(ClientDTO data) {
        Client client = new Client(data);

        return new ClientDTO(this.repository.save(client));
    }
}
