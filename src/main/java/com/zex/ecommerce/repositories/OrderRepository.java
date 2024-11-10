package com.zex.ecommerce.repositories;

import com.zex.ecommerce.domain.client.Client;
import com.zex.ecommerce.domain.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, String> {


    Page<Order> findByClientOrderByOrderDateDesc(Client client, Pageable pageable);
}
