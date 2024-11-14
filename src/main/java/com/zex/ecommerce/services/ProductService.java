package com.zex.ecommerce.services;

import com.zex.ecommerce.domain.product.*;
import com.zex.ecommerce.domain.product.query.BestSellingProduct;
import com.zex.ecommerce.repositories.OrderedItemRepository;
import com.zex.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderedItemRepository orderedItemRepository;

    @Transactional
    public DetailsProductDTO create(CreateProductDTO data) {
        Product product = new Product(data);
        product.setRegisterDate(LocalDate.now());

        return new DetailsProductDTO(this.productRepository.save(product));
    }


    public Page<SimplifiedProductDTO> getAll(Pageable pageable) {
        Page<Product> products = this.productRepository.findAll(pageable);

        return products.map(p -> new SimplifiedProductDTO(p));
    }

    @Transactional
    public DetailsProductDTO update(UpdateProductDTO data) {
        Product product = this.productRepository.getReferenceById(data.id());

        product.updateProduct(data);

        return new DetailsProductDTO(product);
    }

    @Transactional
    public void delete(String id) {
        Product product = this.productRepository.getReferenceById(id);

        this.productRepository.delete(product);
    }


    public DetailsProductDTO details(String id) {
        Product product = this.getReferenceByID(id);

        return new DetailsProductDTO(product);
    }

    public Product getReferenceByID(String id) {
        return this.productRepository.getReferenceById(id);
    }


    public Page<SimplifiedProductDTO> findByName(String name, Pageable pageable) {


        return this.productRepository.findByNameContainingIgnoreCaseOrderByValue(name, pageable)
                .map(p -> new SimplifiedProductDTO(p));
    }


    public Page<SimplifiedProductDTO> findByCategory(Category category, Pageable pageable) {
        return this.productRepository.findByCategoryOrderByValue(category, pageable)
                .map(p -> new SimplifiedProductDTO(p));
    }


    public Page<BestSellingProduct> getBestSellingProducts(Pageable pageable) {
        return this.orderedItemRepository.findBestSellingProducts(pageable);
    }

}
