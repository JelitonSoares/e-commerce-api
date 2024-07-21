package com.zex.ecommerce.services;

import com.zex.ecommerce.dtos.product.CreateProductDTO;
import com.zex.ecommerce.dtos.product.UpdateProductDTO;
import com.zex.ecommerce.models.product.Product;
import com.zex.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public CreateProductDTO save(CreateProductDTO data) {
        Product product = new Product(data);
        product.setRegisterDate(LocalDate.now());

        return new CreateProductDTO(this.repository.save(product));
    }


    public List<CreateProductDTO> findAll() {
        List<Product> products = this.repository.findAll();

        return products.stream()
                .map(p -> new CreateProductDTO(p))
                .collect(Collectors.toList());
    }

    @Transactional
    public CreateProductDTO update(UpdateProductDTO data) {
        Product product = this.repository.getReferenceById(data.id());

        product.updateProduct(data);

        return new CreateProductDTO(product);
    }

    @Transactional
    public void delete(UUID id) {
        Product product = this.repository.getReferenceById(id);

        this.repository.delete(product);
    }

    public Product getReferenceByID(UUID id) {
        return this.repository.getReferenceById(id);
    }
}
