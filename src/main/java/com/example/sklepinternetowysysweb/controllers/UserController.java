package com.example.sklepinternetowysysweb.controllers;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.UserRepository;
import com.example.sklepinternetowysysweb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;


@org.springframework.stereotype.Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                                  BindingResult result, ModelMap model) {

        User existingUser = userService.findByEmailAddress(user.getEmailAddress());

        if(existingUser != null && existingUser.getEmailAddress() != null && !existingUser.getEmailAddress().isEmpty()){
            result.rejectValue("emailAddress", null,
                    "There is already an account registered with the same email");
        }


        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }

        userService.save(user);

        model.addAttribute("message", "User SignUp successfully.");
        model.addAttribute("user", user);
        return "signupSuccess";
    }

    @GetMapping("/login")
    public String loginUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/authenticated")
    public String authenticated(Model model, Principal principal) {
        User user = userService.findByEmailAddress(principal.getName());
        model.addAttribute("currentUser", user);
        System.out.println(user.getFirstName());
        return "authenticated";
    }

    @GetMapping("/account")
    public String loginUser(Model model, Principal principal) {
        User user = userService.findByEmailAddress(principal.getName());
        model.addAttribute("currentUser", user);
        return "account";
    }

    @PostMapping("/account/change")
    public String changeAccount(@ModelAttribute("currentUser") User user,
                                BindingResult result, ModelMap model, Principal principal) {
        User originalUser = userRepository.findByEmailAddress(principal.getName());
        if(user.getPassword().equals("Enter new password")){
            System.out.println(originalUser.getEmailAddress()+ "ZOSTAJE STARE HASLO" + originalUser.getPassword());
            user.setPassword(originalUser.getPassword());
            userService.savePlain(user);
            System.out.println("po robocie" + user.getPassword());
            return "authenticated";
        }else{
            System.out.println(" NOWE HASLO" + user.getPassword());
            userService.save(user);
        }

        return "authenticated";
    }
}
