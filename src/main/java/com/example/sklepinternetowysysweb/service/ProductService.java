package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Category;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product) { productRepository.save(product); }

    public List<Product> findByCategory(Category category) { return productRepository.findByCategory(category); }

    public List<Product> findAll() { return productRepository.findAll(); }
}
