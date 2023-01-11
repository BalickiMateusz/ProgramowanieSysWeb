package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class CartService {

    private final CartRepository cartRepository;

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public Cart findCartByUser(User user){
       return cartRepository.findCartByUser(user);
    }

    public void deleteAllByUser(User user){
        cartRepository.deleteAllByUser(user);
    }
}
