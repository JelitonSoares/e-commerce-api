package com.zex.ecommerce.services;

import com.zex.ecommerce.domain.order.*;
import com.zex.ecommerce.domain.client.Client;
import com.zex.ecommerce.domain.ordereditens.OrderedItens;
import com.zex.ecommerce.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @Transactional
    public OrderDTO create(CreateOrderDTO data) {

        List<OrderedItens> itens = data.products().stream()
                .map(p -> new OrderedItens(this.productService.getReferenceByID(p.productId()),p.amount()))
                .collect(Collectors.toList());

        itens.forEach(i -> i.getProduct().setOrderedItensList(itens));
        itens.forEach(i -> i.getProduct().updateStock(i.getAmount()));


        Order order = new Order();

        Client client = this.clientService.getReferenceByID(data.clientId());
        order.setClient(client);
        order.setOrderDate(LocalDate.now());
        order.setOrderedItensList(itens);

        Order orderSaved = this.repository.save(order);

        return new OrderDTO(orderSaved);
    }

    public Page<OrderSimplifiedDTO> findAll(Pageable pageable) {
        Page<Order> orders = this.repository.findAll(pageable);

        return orders.map(o -> new OrderSimplifiedDTO(o));

    }

    @Transactional
    public OrderDTO update(UpdateOrderDTO data) {
        Order reference  = this.repository.getReferenceById(data.orderId());
        List<OrderedItens> orderedItems = reference.getOrderedItensList();

         orderedItems.stream()
                .filter(items -> items.getProduct().getId().equals(data.productId()))
                .forEach(items -> items.setAmount(data.amount()));

        reference.updateTotalValue();

        Order orderUpdated = this.repository.save(reference);

         return new OrderDTO(orderUpdated);
    }

    @Transactional
    public void delete(UUID id){
        Order reference = this.repository.getReferenceById(id);


        this.repository.delete(reference);
    }
}
