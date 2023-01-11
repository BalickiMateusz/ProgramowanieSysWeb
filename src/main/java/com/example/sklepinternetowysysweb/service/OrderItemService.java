package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.OrderItem;
import com.example.sklepinternetowysysweb.persistance.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public void save(OrderItem orderItem) { orderItemRepository.save(orderItem); }
}
