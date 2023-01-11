package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.CartItem;
import com.example.sklepinternetowysysweb.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    CartItem findCartItemByProductAndCart(Product product, Cart cart);
    void deleteAllByCart(Cart cart);

    void deleteById(Integer id);

    List<CartItem> findCartItemsByCart(Cart cart);
}