package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.Category;
import com.example.sklepinternetowysysweb.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}