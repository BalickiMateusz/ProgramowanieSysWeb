package com.example.sklepinternetowysysweb.controllers;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.CartItem;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.CartItemRepository;
import com.example.sklepinternetowysysweb.persistance.CartRepository;
import com.example.sklepinternetowysysweb.persistance.ProductRepository;
import com.example.sklepinternetowysysweb.service.CartItemService;
import com.example.sklepinternetowysysweb.service.CartService;
import com.example.sklepinternetowysysweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
public class ShoppingCartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartRepository cartRepository;

    @ModelAttribute

    @PostMapping("/addToCart")
    public void addToShoppingCart(@ModelAttribute("productToCart") Product product,
                                  BindingResult result, ModelMap model, Principal principal) {

        User user = userService.findByEmailAddress(principal.getName());
        Cart cart = cartService.findCartByUser(user);
        if(cart == null) {
            cart = new Cart();
            cart.setTotalWeight(0.0f);
            cart.setTotalPrice(0.0f);
            cart.setUser(user);
            cartService.save(cart);
        }

        CartItem cartItem = cartItemService.findCartItemByProductAndCart(product,cart);

        if(cartItem == null){
            cartItem = new CartItem();
            cart.setTotalWeight(cart.getTotalWeight() + product.getWeight());
            cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setCart(cart);
            cartItemService.save(cartItem);
            cartService.save(cart);
        }
    }

    @PostMapping("/quantity")
    public @ResponseBody String addQuantity(@ModelAttribute("quantity") CartItem cartItem,
                                  BindingResult result, ModelMap model, Principal principal) {

        User user = userService.findByEmailAddress(principal.getName());
        Cart cart = cartService.findCartByUser(user);

        CartItem oldItem = cartItemService.findCartItemByProductAndCart(cartItem.getProduct(),cart);
        int oldQuantity = oldItem.getQuantity();
        int newQuantity = cartItem.getQuantity();

        if(newQuantity < 0){
            return "ltZero";
        }
        if(newQuantity > oldItem.getProduct().getStock()){
            return "btStock";
        }

        if(oldQuantity == newQuantity){
            return String.valueOf(cart.getTotalPrice());
        }else {
            if (newQuantity == 0) {
                cartItemService.deleteById(oldItem.getId());
            } else {
                oldItem.setQuantity(cartItem.getQuantity());
                cartItemService.save(oldItem);
            }
            cart.setTotalPrice(cart.getTotalPrice() + cartItem.getProduct().getPrice() * (newQuantity - oldQuantity));
            cart.setTotalWeight(cart.getTotalWeight() + cartItem.getProduct().getWeight() * (newQuantity - oldQuantity));
            cartService.save(cart);
        }

        return String.valueOf(cart.getTotalPrice());
    }

    @GetMapping("/cart")
    public String listProducts(Model model, Principal principal){
        User user = userService.findByEmailAddress(principal.getName());
        Cart cart = cartService.findCartByUser(user);

        List<CartItem> cartItems = cartItemService.findCartItemsByCart(cart);
        List<Product> products = cartItems.stream().map(item -> item.getProduct()).collect(Collectors.toList());

        Comparator<Product> comparator = null;

        comparator = Comparator.comparing(Product::getName);

        products = products.stream().sorted(comparator).collect(Collectors.toList());

        Map<Integer, Integer> mapCartItems = new HashMap<>();
        mapCartItems = cartItems.stream().collect(Collectors.toMap(CartItem::getProductId, CartItem::getQuantity));
//s
//        for (int i=0; i<products.size();i++) {
//            mapCartItems.put(products.get(i).getId(), cartItems.get(i).getQuantity());
//        }

        model.addAttribute("totalPrice", cart.getTotalPrice());
        model.addAttribute("mapCartItems", mapCartItems);
        model.addAttribute("products", products);
        model.addAttribute("quantity", new CartItem());
        return "cart";
    }

}
