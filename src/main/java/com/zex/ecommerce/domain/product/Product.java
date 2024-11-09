package com.zex.ecommerce.domain.product;

import com.zex.ecommerce.domain.ordereditens.OrderedItens;
import com.zex.ecommerce.infra.exceptions.ProductStockException;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "Product")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "product_name")
    private String name;


    @Column(name = "product_description")
    private String description;


    @Column(name = "product_value")
    private BigDecimal value;


    @Column(name = "product_stock")
    private Integer stock;


    @Column(name = "product_category")
    @Enumerated(value = EnumType.STRING)
    private Category category;


    @Column(name = "product_register_date")
    private LocalDate registerDate;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderedItens> orderedItensList;

    public Product(CreateProductDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.value = data.value();
        this.stock = data.stock();
        this.category = data.category();
    }

    public void updateProduct(UpdateProductDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }

        if (data.description() != null) {
            this.description = data.description();
        }

        if (data.value() != null) {
            this.value = data.value();
        }

        if (data.stock() != null) {
            this.stock = this.stock + data.stock();
        }
    }

    public void addOrderedItens(OrderedItens itens) {
        this.orderedItensList.add(itens);
    }

    public void updateStock(Integer amount) {

        if (this.stock < amount) {
            throw new ProductStockException("insufficient products in stock/" + " in stock: " + this.stock + ", amount: " + amount);
        }

        this.stock = stock - amount;
    }
}
