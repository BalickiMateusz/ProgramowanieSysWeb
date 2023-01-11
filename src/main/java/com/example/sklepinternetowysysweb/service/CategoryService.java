package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.Category;
import com.example.sklepinternetowysysweb.persistance.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAll() { return categoryRepository.findAll(); }

    public Category findByName(String name) { return categoryRepository.findByName(name); }

}
