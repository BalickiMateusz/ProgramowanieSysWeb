package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findCartByUser(User user);

    void deleteAllByUser(User user);
}