package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.CartItem;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.persistance.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public CartItem findCartItemByProductAndCart(Product product, Cart cart){return cartItemRepository.findCartItemByProductAndCart(product, cart);}

    public void deleteAllByCart(Cart cart){cartItemRepository.deleteAllByCart(cart);}

    public void deleteById(Integer id){cartItemRepository.deleteById(id);}
    public List<CartItem> findCartItemsByCart(Cart cart){return cartItemRepository.findCartItemsByCart(cart);}
}
