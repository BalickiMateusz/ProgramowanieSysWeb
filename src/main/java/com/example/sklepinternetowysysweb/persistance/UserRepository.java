package com.example.sklepinternetowysysweb.persistance;

import com.example.sklepinternetowysysweb.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAddress(String email);
    User findByLogin(String login);
    User findByPhoneNumber(String phoneNumber);
}