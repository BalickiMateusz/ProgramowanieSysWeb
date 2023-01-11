package com.example.sklepinternetowysysweb.config;

import com.example.sklepinternetowysysweb.persistance.*;
import com.example.sklepinternetowysysweb.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class PersistenceConfig {

    @Bean
    public AddressService addressService(AddressRepository addressRepository) {
        return new AddressService(addressRepository);
    }

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }

    @Bean
    public OrderItemService orderItemService(OrderItemRepository orderItemRepository) {
        return new OrderItemService(orderItemRepository);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

    @Bean
    public SupplierService supplierService(SupplierRepository supplierRepository) {
        return new SupplierService(supplierRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public CartService cartService(CartRepository cartRepository) {
        return new CartService(cartRepository);
    }

    @Bean
    public CartItemService cartItemService(CartItemRepository cartItemRepository) {
        return new CartItemService(cartItemRepository);
    }

}
