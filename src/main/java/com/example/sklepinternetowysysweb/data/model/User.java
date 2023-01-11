package com.example.sklepinternetowysysweb.data.model;

import com.example.sklepinternetowysysweb.validation.ValidEmail;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @NotNull
    @NotEmpty
    @Column(name = "second_name", nullable = false, length = 64)
    private String secondName;

    @ValidEmail
    @NotNull
    @NotEmpty
    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @NotNull
    @NotEmpty
    @Column(name = "login", nullable = false, length = 64)
    private String login;

    @NotNull
    @NotEmpty
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "country", nullable = false, length = 64)
    private String country;

    @Column(name = "gender", length = 32)
    private String gender;

    @Column(name = "phone_number", length = 16)
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}