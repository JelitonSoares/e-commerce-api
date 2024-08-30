package com.zex.ecommerce.domain.order;

import com.zex.ecommerce.domain.client.Client;
import com.zex.ecommerce.domain.ordereditens.OrderedItens;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "order")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
    private BigDecimal totalValue = BigDecimal.ZERO;


    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderedItens> orderedItensList;

    public void setClient(Client client) {
        client.addOrder(this);
        this.client = client;
    }

    public void addOrderedItens(OrderedItens itens) {
        this.orderedItensList.add(itens);
    }

    public void setOrderedItensList(List<OrderedItens> itens) {
        itens.forEach(i -> i.setOrder(this));
        this.orderedItensList = itens;
        this.orderedItensList.forEach(o -> this.totalValue = totalValue.add(o.totalValue()));
    }


}
