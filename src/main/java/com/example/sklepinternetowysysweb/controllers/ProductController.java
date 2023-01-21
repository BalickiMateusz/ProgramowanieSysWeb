package com.example.sklepinternetowysysweb.controllers;

import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.CartItem;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.CartItemRepository;
import com.example.sklepinternetowysysweb.persistance.CartRepository;
import com.example.sklepinternetowysysweb.persistance.SupplierRepository;
import com.example.sklepinternetowysysweb.persistance.UserRepository;
import com.example.sklepinternetowysysweb.service.CartItemService;
import com.example.sklepinternetowysysweb.service.CartService;
import com.example.sklepinternetowysysweb.service.CategoryService;
import com.example.sklepinternetowysysweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//@ControllerAdvice
@org.springframework.stereotype.Controller
public class ProductController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/products/{category}")
    public String listProducts(Model model, @PathVariable("category") String givenCategory,
                               @RequestParam(value = "sortBy", defaultValue = "name", required = false) List<String> sort,
                               @RequestParam(value = "count", required =false, defaultValue = "8") String count,
                               @RequestParam(value = "page", required =false, defaultValue = "1") String page, Principal principal){

        List<Product> products;

        if (givenCategory.equals("all")) {
            products = productService.findAll();
        }
        else{
            products = productService.findByCategory(categoryService.findByName(givenCategory));
        }

        int maxPage = (int) Math.ceil(products.size()/Integer.valueOf(count));
        if(maxPage == 0) maxPage=1;

        if(!count.matches("\\d+")){
            count = "8";
        }

        if(!page.matches("\\d+")){
            page = "1";
        } else if(Integer.valueOf(page) < 1){
            page="1";
        } else if(Integer.valueOf(page) > maxPage){
            page= String.valueOf(maxPage);
        }

        int nextPage = 0;
        int previousPage = 0;

        if(page=="1"){
            nextPage = Integer.valueOf(page)+1;
            previousPage = maxPage;
        }else if(page==String.valueOf(maxPage)){
            nextPage = 1;
            previousPage = Integer.valueOf(page)-1;
        }else{
            nextPage = Integer.valueOf(page)+1;
            previousPage = Integer.valueOf(page)-1;
        }

        products = getPage(products, Integer.valueOf(page), Integer.valueOf(count));

        products = sortProducts(products, sort);
        System.out.println(Arrays.toString(products.toArray()));

        List<String> categories = categoryService.findAll().stream().map(category -> category.getName()).collect(Collectors.toList());

        model.addAttribute("nextPage", nextPage);
        model.addAttribute("previousPage", previousPage);
        model.addAttribute("sortBy", String.join(",", sort));
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("productToCart", new Product());
        model.addAttribute("cartQuantity", cartQuantity(principal));
        model.addAttribute("addedIds", cartItems(principal));

        return "hello";
    }

    private List<Product> getPage(List<Product> list, int page, int pageSize){
        System.out.println("KSAKSAKSA" + page);
        int fromIndex = (page - 1) * pageSize;
        return list.subList(fromIndex, Math.min(fromIndex + pageSize, list.size()));
    }

    private List<Product> sortProducts(List<Product> products, List<String> sort){
        if(sort == null){
            return products;
        }
        Comparator<Product> comparator = null;

        if(sort.contains("name")){
            comparator = Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER);
        }
        if(sort.contains("price")){
            comparator = Comparator.comparing(Product::getPrice);
        }

        return products.stream().sorted(comparator).collect(Collectors.toList());
    }

    private int cartQuantity(Principal principal){
        User user = userRepository.findByEmailAddress(principal.getName());
        Cart cart = cartRepository.findCartByUser(user);
        if(cart == null) return 0;
        return cartItemService.findCartItemsByCart(cart).size();

    }

    private List<Integer> cartItems(Principal principal){
        User user = userRepository.findByEmailAddress(principal.getName());
        Cart cart = cartRepository.findCartByUser(user);
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCart(cart);
        List<Integer> addedIds = cartItems.stream().map(item -> item.getProduct().getId()).collect(Collectors.toList());

        return addedIds;
    }
}
