package com.zex.ecommerce.models.ordereditens;

import com.zex.ecommerce.models.order.Order;
import com.zex.ecommerce.models.product.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "ordered_itens")
@Table(name = "ordered_itens")
public class OrderedItens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

    @Column(name  = "unitary_value")
    private BigDecimal unitaryValue;

}
