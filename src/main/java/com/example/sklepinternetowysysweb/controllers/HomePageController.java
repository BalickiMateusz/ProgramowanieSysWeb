package com.example.sklepinternetowysysweb.controllers;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class HomePageController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
