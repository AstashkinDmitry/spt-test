package com.spt.test.service;

import com.spt.test.entity.ProductOrder;
import com.spt.test.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductOrderService {

    private final OrderRepository orderRepository;

    public ProductOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<ProductOrder> getAll() {
        return orderRepository.findAll();
    }

    public ProductOrder createOrder(ProductOrder order) {
        return orderRepository.save(order);
    }
}
