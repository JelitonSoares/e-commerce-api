package com.zex.ecommerce.models.client;

import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_document")
    private String document;

    @Embedded
    private Address address;
}
