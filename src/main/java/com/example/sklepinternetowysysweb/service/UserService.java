package com.example.sklepinternetowysysweb.service;

import com.example.sklepinternetowysysweb.data.model.User;
import com.example.sklepinternetowysysweb.persistance.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void savePlain(User user) {
        userRepository.save(user);
    }

    public User findByEmailAddress(String emailAddress) { return userRepository.findByEmailAddress(emailAddress); }

    public User findByLogin(String login) { return userRepository.findByLogin(login); }

    public User findByPhoneNumber(String phoneNumber) { return userRepository.findByPhoneNumber(phoneNumber); }
}
