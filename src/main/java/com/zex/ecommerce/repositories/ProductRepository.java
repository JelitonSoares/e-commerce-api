package com.zex.ecommerce.repositories;

import com.zex.ecommerce.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
