package com.zex.ecommerce.repositories;

import com.zex.ecommerce.domain.ordereditens.OrderedItens;
import com.zex.ecommerce.domain.product.query.BestSellingProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderedItemRepository extends JpaRepository<OrderedItens, String> {

    @Query(value = """
            SELECT p.id AS product_id, p.product_name AS product_name, SUM(i.amount) AS total_sold
            FROM ordered_itens i
            JOIN products p ON i.product_id = p.id
            GROUP BY p.id, p.product_name
            ORDER BY total_sold DESC""", nativeQuery = true)
    Page<BestSellingProduct> findBestSellingProducts(Pageable pageable);
}
