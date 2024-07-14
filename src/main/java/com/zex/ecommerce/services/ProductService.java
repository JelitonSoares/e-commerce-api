package com.zex.ecommerce.services;

import com.zex.ecommerce.dtos.ProductDTO;
import com.zex.ecommerce.dtos.UpdateProductDTO;
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
    public ProductDTO save(ProductDTO data) {
        Product product = new Product(data);
        product.setRegisterDate(LocalDate.now());

        return new ProductDTO(this.repository.save(product));
    }


    public List<ProductDTO> findAll() {
        List<Product> products = this.repository.findAll();

        return products.stream()
                .map(p -> new ProductDTO(p))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO update(UpdateProductDTO data) {
        Product product = this.repository.getReferenceById(data.id());

        product.updateProduct(data);

        return new ProductDTO(product);
    }

    @Transactional
    public void delete(UUID id) {
        Product product = this.repository.getReferenceById(id);

        this.repository.delete(product);
    }
}
