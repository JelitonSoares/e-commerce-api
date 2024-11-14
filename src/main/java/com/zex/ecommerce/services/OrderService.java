package com.zex.ecommerce.services;

import com.zex.ecommerce.domain.client.Client;
import com.zex.ecommerce.domain.client.query.Top5Clients;
import com.zex.ecommerce.domain.client.query.TotalAmountSpentByClients;
import com.zex.ecommerce.domain.order.*;
import com.zex.ecommerce.domain.ordereditens.OrderedItens;
import com.zex.ecommerce.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
    public DetailsOrderDTO create(CreateOrderDTO data) {

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

        return new DetailsOrderDTO(orderSaved);
    }

    public Page<SimplifiedOrderDTO> findAll(Pageable pageable) {
        Page<Order> orders = this.repository.findAll(pageable);

        return orders.map(o -> new SimplifiedOrderDTO(o));

    }

    @Transactional
    public DetailsOrderDTO update(UpdateOrderDTO data) {
        Order reference  = this.repository.getReferenceById(data.orderId());
        List<OrderedItens> orderedItems = reference.getOrderedItensList();

         orderedItems.stream()
                .filter(items -> items.getProduct().getId().equals(data.productId()))
                .forEach(items -> items.setAmount(data.amount()));

        reference.updateTotalValue();

        Order orderUpdated = this.repository.save(reference);

         return new DetailsOrderDTO(orderUpdated);
    }

    @Transactional
    public void delete(String id){
        Order reference = this.repository.getReferenceById(id);


        this.repository.delete(reference);
    }

    public DetailsOrderDTO details(String id) {
        Order reference = this.repository.getReferenceById(id);

        return new DetailsOrderDTO(reference);
    }

    public Page<DetailsOrderDTO> findByClient(String id, Pageable pageable) {
        Client client = clientService.getReferenceByID(id);

        return this.repository.findByClientOrderByOrderDateDesc(client, pageable)
                .map(o -> new DetailsOrderDTO(o));
    }


    public Page<Top5Clients> getTop5Clients(Pageable pageable) {
        return this.repository.getTop5Clients(pageable);
    }


    public Page<TotalAmountSpentByClients> getTotalAmountSpentByClients(Pageable pageable) {
        return this.repository.getTotalAmountSpent(pageable);
    }
}
