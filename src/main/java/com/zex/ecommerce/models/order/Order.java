package com.zex.ecommerce.models.order;

import com.zex.ecommerce.models.client.Client;
import com.zex.ecommerce.models.ordereditens.OrderedItens;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "order_total_value")
    private BigDecimal totalValue;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderedItens> orderedItensList;
}
