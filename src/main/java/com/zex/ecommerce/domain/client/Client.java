package com.zex.ecommerce.domain.client;

import com.zex.ecommerce.domain.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "client")
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_document", unique = true)
    private String document;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Client(CreateClientDTO data) {
        this.name = data.name();
        this.document = data.document();
        this.address = new Address(data.address());
    }

    public void updateClient (UpdateClientDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }

        if (data.address() != null) {
            this.address.updateAddress(data.address());
        }
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
