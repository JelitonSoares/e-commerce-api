package com.zex.ecommerce.models.product;

import com.zex.ecommerce.dtos.ProductDTO;
import com.zex.ecommerce.dtos.UpdateProductDTO;
import com.zex.ecommerce.models.ordereditens.OrderedItens;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "product")
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderedItens> orderedItensList;

    public Product(ProductDTO data) {
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
}
