package com.example.sklepinternetowysysweb.controllers;

import com.example.sklepinternetowysysweb.data.model.*;
import com.example.sklepinternetowysysweb.persistance.CartItemRepository;
import com.example.sklepinternetowysysweb.persistance.CartRepository;
import com.example.sklepinternetowysysweb.persistance.ProductRepository;
import com.example.sklepinternetowysysweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;
//
//    @PostMapping("/addToCart")
//    public void addToShoppingCart(@ModelAttribute("productToCart") Product product,
//                                  BindingResult result, ModelMap model, Principal principal) {
//
//        User user = userService.findByEmailAddress(principal.getName());
//        Cart cart = cartService.findCartByUser(user);
//        System.out.println("LALALA"+product.toString());
//        if(cart == null) {
//            cart = new Cart();
//            cart.setTotalWeight(0.0f);
//            cart.setTotalPrice(0.0f);
//            cart.setUser(user);
//            cartService.save(cart);
//        }
//
//        CartItem cartItem = cartItemService.findCartItemByProductAndCart(product,cart);
//
//        if(cartItem == null){
//            cartItem = new CartItem();
//            cart.setTotalWeight(cart.getTotalWeight() + product.getWeight());
//            cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
//            cartItem.setProduct(product);
//            cartItem.setQuantity(1);
//            cartItem.setCart(cart);
//            cartItemService.save(cartItem);
//            cartService.save(cart);
//        }
//    }
//
//    @PostMapping("/quantity")
//    public @ResponseBody String addQuantity(@ModelAttribute("quantity") CartItem cartItem,
//                                  BindingResult result, ModelMap model, Principal principal) {
//
//        User user = userService.findByEmailAddress(principal.getName());
//        Cart cart = cartService.findCartByUser(user);
//
//        CartItem oldItem = cartItemService.findCartItemByProductAndCart(cartItem.getProduct(),cart);
//        int oldQuantity = oldItem.getQuantity();
//        int newQuantity = cartItem.getQuantity();
//
//        if(newQuantity < 0){
//            return "ltZero";
//        }
//        if(newQuantity > oldItem.getProduct().getStock()){
//            return "btStock";
//        }
//
//        if(oldQuantity == newQuantity){
//            return "success";
//        }else {
//            oldItem.setQuantity(cartItem.getQuantity());
//            cartItemService.save(oldItem);
//
//            cart.setTotalPrice(cart.getTotalPrice() + cartItem.getProduct().getPrice()*(newQuantity - oldQuantity));
//            cartService.save(cart);
//        }
//        return "success";
//    }

    @GetMapping("/order")
    public String orderForm(Model model, Principal principal){
        User user = userService.findByEmailAddress(principal.getName());
        Cart cart = cartService.findCartByUser(user);
        List<Supplier> suppliers = supplierService.getAll();

        model.addAttribute("suppliers", suppliers);
        model.addAttribute("totalPrice", cart.getTotalPrice());
        model.addAttribute("totalWeight", cart.getTotalWeight());
        model.addAttribute("order", new Order());
        return "order";
    }

}
