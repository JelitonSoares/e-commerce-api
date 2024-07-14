package com.zex.ecommerce.services;

import com.zex.ecommerce.dtos.ProductDTO;
import com.zex.ecommerce.models.product.Product;
import com.zex.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductDTO save(ProductDTO data) {
        Product product = new Product(data);
        product.setRegisterDate(LocalDate.now());

        return new ProductDTO(this.repository.save(product));
    }
}
