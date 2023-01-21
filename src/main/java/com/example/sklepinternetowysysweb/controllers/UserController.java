package com.example.sklepinternetowysysweb.controllers;
import com.example.sklepinternetowysysweb.data.model.Cart;
import com.example.sklepinternetowysysweb.data.model.Product;
import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.UserRepository;
import com.example.sklepinternetowysysweb.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import org.springframework.stereotype.Controller;

import jakarta.validation.Valid;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class UserController implements WebMvcConfigurer {

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
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        System.out.println(user.toString());
        User existingUser = userService.findByEmailAddress(user.getEmailAddress());

        if(existingUser != null && existingUser.getEmailAddress() != null && !existingUser.getEmailAddress().isEmpty()){
            bindingResult.rejectValue("emailAddress", null,
                    "There is already an account registered with the same email");
        }

        if(!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")){
            bindingResult.rejectValue("password", null,
                    "Minimum eight characters, at least one letter and one number:");
        };
        System.out.println(bindingResult.getModel());
        if(bindingResult.hasErrors()){
//            model.addAttribute("user", user);
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
    public String changeAccount(@Valid @ModelAttribute("currentUser") User user,
                                BindingResult result, ModelMap model, Principal principal) {

        User existingUser = userService.findByEmailAddress(user.getEmailAddress());

            if(result.hasErrors()){
//                model.addAttribute("currentUser", user);
                return "account";
            }else{


            User originalUser = userRepository.findByEmailAddress(principal.getName());
            Boolean flag = originalUser.getEmailAddress().equals(user.getEmailAddress());
            if(user.getPassword().equals("Enter new password")){
                user.setPassword(originalUser.getPassword());

                if(flag){
                    userService.savePlain(user);
                    return "authenticated";
                }else{

                    if(existingUser != null && existingUser.getEmailAddress() != null && !existingUser.getEmailAddress().isEmpty()){
                        result.rejectValue("emailAddress", null,
                                "There is already an account registered with the same email");
                    }

                    if(result.hasErrors()){
//                model.addAttribute("currentUser", user);
                        return "account";
                    }
                    userService.savePlain(user);
                    return "redirect:/logout";
                }
            }else{

                if(!flag){
                    if(existingUser != null && existingUser.getEmailAddress() != null && !existingUser.getEmailAddress().isEmpty()){
                        result.rejectValue("emailAddress", null,
                                "There is already an account registered with the same email");
                    }
                }


                if(!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")){
                    result.rejectValue("password", null,
                            "Minimum eight characters, at least one letter and one number:");
                };

                if(result.hasErrors()){
//                model.addAttribute("currentUser", user);
                    return "account";
                }

                userService.save(user);
            }
            return "redirect:/logout";
        }
    }
}
