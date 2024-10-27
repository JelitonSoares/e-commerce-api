package com.zex.ecommerce.services;

import com.zex.ecommerce.domain.product.*;
import com.zex.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public DetailsProductDTO create(CreateProductDTO data) {
        Product product = new Product(data);
        product.setRegisterDate(LocalDate.now());

        return new DetailsProductDTO(this.repository.save(product));
    }


    public Page<SimplifiedProductDTO> getAll(Pageable pageable) {
        Page<Product> products = this.repository.findAll(pageable);

        return products.map(p -> new SimplifiedProductDTO(p));
    }

    @Transactional
    public DetailsProductDTO update(UpdateProductDTO data) {
        Product product = this.repository.getReferenceById(data.id());

        product.updateProduct(data);

        return new DetailsProductDTO(product);
    }

    @Transactional
    public void delete(String id) {
        Product product = this.repository.getReferenceById(id);

        this.repository.delete(product);
    }


    public DetailsProductDTO details(String id) {
        Product product = this.getReferenceByID(id);

        return new DetailsProductDTO(product);
    }

    public Product getReferenceByID(String id) {
        return this.repository.getReferenceById(id);
    }
}
