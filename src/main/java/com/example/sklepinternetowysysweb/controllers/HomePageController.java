package com.example.sklepinternetowysysweb.controllers;
import com.example.sklepinternetowysysweb.data.model.Category;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.persistance.CategoryRepository;
import com.example.sklepinternetowysysweb.persistance.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@org.springframework.stereotype.Controller
public class HomePageController {
    @GetMapping("/home")
    public String homePage() {




        return "home";
    }
}
