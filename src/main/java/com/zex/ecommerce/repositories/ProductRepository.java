package com.zex.ecommerce.repositories;

import com.zex.ecommerce.domain.product.Category;
import com.zex.ecommerce.domain.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, String> {


    Page<Product> findByNameContainingIgnoreCaseOrderByValue(String name, Pageable pageable);

    Page<Product> findByCategoryOrderByValue(Category category, Pageable pageable);
}
