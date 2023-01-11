package com.example.sklepinternetowysysweb.security;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.service.CartItemService;
import com.example.sklepinternetowysysweb.service.CartService;
import com.example.sklepinternetowysysweb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomLogoutHandler implements LogoutHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response,
                       Authentication authentication) {
        System.out.println("KAKKAKA");
        User user = userService.findByEmailAddress(authentication.getName());
        Cart cart = cartService.findCartByUser(user);

        cartItemService.deleteAllByCart(cart);
        cartService.deleteAllByUser(user);
    }
}
