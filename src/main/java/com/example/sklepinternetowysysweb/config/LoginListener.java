package com.example.sklepinternetowysysweb.config;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.UserRepository;
import com.example.sklepinternetowysysweb.service.CartItemService;
import com.example.sklepinternetowysysweb.service.CartService;
import com.example.sklepinternetowysysweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class LoginListener implements
        ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        User user = userService.findByEmailAddress(event.getAuthentication().getName());
        Cart cart = cartService.findCartByUser(user);

        cartItemService.deleteAllByCart(cart);
        cartService.deleteAllByUser(user);

        Cart cart1 = new Cart();
        cart1.setUser(user);
        cart1.setTotalWeight(0.0f);
        cart1.setTotalPrice(0.0f);

        cartService.save(cart1);
    }
}