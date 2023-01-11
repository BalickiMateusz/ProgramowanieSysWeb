package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Order;
import com.example.sklepinternetowysysweb.persistance.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }
}
