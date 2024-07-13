package com.zex.ecommerce.models.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Column(name = "client_public_place")
    private String publicPlace;

    @Column(name = "client_number")
    private Integer number;

    @Column(name = "client_neighborhood")
    private String neighborhood;

    @Column(name = "client_city")
    private String city;

    @Column(name = "client_uf")
    private String uf;

    @Column(name = "client_cep")
    private String cep;

    @Column(name = "client_complement")
    private String complement;
}
