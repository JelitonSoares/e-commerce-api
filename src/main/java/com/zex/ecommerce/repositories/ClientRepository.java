package com.zex.ecommerce.repositories;

import com.zex.ecommerce.domain.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, String> {


    Page<Client> findByNameContainingIgnoreCase(String name, Pageable pageable);


    Client findByDocument(String document);
}
