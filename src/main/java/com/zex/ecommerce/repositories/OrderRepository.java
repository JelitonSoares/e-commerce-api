package com.zex.ecommerce.repositories;

import com.zex.ecommerce.domain.client.Client;
import com.zex.ecommerce.domain.client.query.Top5Clients;
import com.zex.ecommerce.domain.client.query.TotalAmountSpentByClients;
import com.zex.ecommerce.domain.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, String> {


    Page<Order> findByClientOrderByOrderDateDesc(Client client, Pageable pageable);


    @Query(value = """
            SELECT c.client_name AS client_name, COUNT(o.client_ID) AS quantity_of_orders
            FROM orders o
            JOIN clients c ON o.client_id = c.id
            GROUP BY c.client_name
            ORDER BY quantity_of_orders DESC;
            """, nativeQuery = true)
    Page<Top5Clients> getTop5Clients(Pageable pageable);

    @Query(value = """
            SELECT c.client_name AS client_name, SUM(o.order_total_value) AS total_amount_spent
            FROM orders o
            JOIN clients c ON o.client_id = c.id
            GROUP BY c.client_name
            ORDER BY total_amount_spent DESC;
            """, nativeQuery = true)
    Page<TotalAmountSpentByClients> getTotalAmountSpent(Pageable pageable);
}
