package com.zex.ecommerce.repositories;

import com.zex.ecommerce.models.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}