package com.zex.ecommerce.models.client;

import com.zex.ecommerce.dtos.client.CreateAddressDTO;
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


    public Address(CreateAddressDTO data) {
        this.publicPlace = data.publicPlace();
        this.number = data.number();
        this.neighborhood = data.neighborhood();
        this.city = data.city();
        this.uf = data.uf();
        this.cep = data.cep();
        this.complement = data.complement();
    }

    public void updateAddress(CreateAddressDTO data) {
        if(data.publicPlace() != null) {
            this.publicPlace = data.publicPlace();
        }

        if(data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }

        if(data.city() != null) {
            this.city = data.city();
        }

        if(data.uf() != null) {
            this.uf = data.uf();
        }

        if(data.cep() != null) {
            this.cep = data.cep();
        }

    }
}
