package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}