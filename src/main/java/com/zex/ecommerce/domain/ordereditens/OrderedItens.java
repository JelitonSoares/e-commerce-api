package com.zex.ecommerce.domain.ordereditens;

import com.zex.ecommerce.domain.order.Order;
import com.zex.ecommerce.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "ordered_itens")
@Table(name = "ordered_itens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedItens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

    @Column(name  = "unitary_value")
    private BigDecimal unitaryValue;





    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderedItens (Product product, Integer amount) {
        this.amount = amount;
        this.product = product;
        this.unitaryValue = product.getValue();
    }

    public BigDecimal totalValue() {
        return this.unitaryValue.multiply(new BigDecimal(this.amount));
    }

}
