package com.example.sklepinternetowysysweb.controllers;

import com.example.sklepinternetowysysweb.data.model.*;
import com.example.sklepinternetowysysweb.persistance.*;
import com.example.sklepinternetowysysweb.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.security.Principal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private OrderItemService orderItemService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @PostMapping("/placeOrder")
    public String placeOrder(@Valid  @ModelAttribute("order") Order order,
                                  BindingResult result, ModelMap model, Principal principal) {

        if(result.hasErrors()){
            return "order";
        }

        User user = userService.findByEmailAddress(principal.getName());
        Cart cart = cartService.findCartByUser(user);

        List<CartItem> cartItems = cartItemService.findCartItemsByCart(cart);
        List<Product> products = cartItems.stream().map(item -> item.getProduct()).collect(Collectors.toList());

        addressService.save(order.getAddress());
        order.setUser(user);
        order.setOrderStatus("order placed");
        order.setOrderDate(LocalDate.now());
        order.setDeliveryStatus("processing delivery");
//        order.setTotalPrice(cart.getTotalPrice());

        orderService.save(order);

        for(int i=0; i<products.size(); i++){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(products.get(i));
            orderItem.setOrder(order);
            orderItem.setQuantity(cartItemService.findCartItemByProductAndCart(products.get(i), cart).getQuantity());
            orderItemService.save(orderItem);
        }

        cartItemService.deleteAllByCart(cart);
        cartService.deleteAllByUser(user);

        Cart cart1 = new Cart();
        cart1.setUser(user);
        cart1.setTotalWeight(0.0f);
        cart1.setTotalPrice(0.0f);
        cartService.save(cart1);

        return "orderSuccess";
    }

    @GetMapping("/order")
    public String orderForm(Model model, Principal principal){
//        User user = userService.findByEmailAddress(principal.getName());
//        Cart cart = cartService.findCartByUser(user);
//        List<Supplier> suppliers = supplierService.getAll();
//
//        model.addAttribute("suppliers", suppliers);
//        model.addAttribute("totalPrice", cart.getTotalPrice());
//        model.addAttribute("totalWeight",  BigDecimal.valueOf(cart.getTotalWeight())
//                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
//                .floatValue());
//
//        model.addAttribute("user", user);
//        model.addAttribute("order", new Order());
        return "order";
    }

    @ModelAttribute
    public void init(Model model, Principal principal) {
        User user = userService.findByEmailAddress(principal.getName());
        Cart cart = cartService.findCartByUser(user);
        List<Supplier> suppliers = supplierService.getAll();

        model.addAttribute("suppliers", suppliers);
        model.addAttribute("totalPrice", cart.getTotalPrice());
        model.addAttribute("totalWeight",  BigDecimal.valueOf(cart.getTotalWeight())
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .floatValue());

        model.addAttribute("user", user);
        model.addAttribute("order", new Order());
    }
}
