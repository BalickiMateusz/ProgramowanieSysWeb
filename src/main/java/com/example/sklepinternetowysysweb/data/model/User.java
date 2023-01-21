package com.example.sklepinternetowysysweb.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.experimental.FieldNameConstants;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 64, message="Wrong size, must be from 2 to 64 chars")
    @Pattern(message = "Wrong input provided!", regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$")
    @NotBlank(message="Can not be empty!")
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Pattern(message = "Wrong input provided!" ,regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$")
    @NotNull(message="Can not be empty!")
    @Size(min = 2, max = 64, message="Wrong size, must be from 2 to 64 chars")
    @Column(name = "second_name", nullable = false, length = 64)
    private String secondName;


    @Email(message = "Wrong email")
    @Pattern(message = "Wrong input provided!" ,regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotNull(message="Can not be empty!")
    @Size(min = 3, max = 255, message="Wrong size, must be from 3 to 255 chars")
    @Column(name = "email_address", nullable = false)
    private String emailAddress;


    @Pattern(message = "Wrong input provided!" ,regexp = "[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$")
    @NotNull(message="Can not be empty!")
    @Size(min = 4, max = 64, message="Wrong size, must be from 4 to 64 chars")
    @Column(name = "login", nullable = false, length = 64)
    private String login;

    @NotNull(message="Can not be empty!")
    @Column(name = "password", nullable = false, length = 64)
    private String password;


    @Size(min = 4, max = 64, message="Wrong size, must be from 4 to 64 chars")
    @Pattern(message = "Wrong input provided!" , regexp = "[a-zA-Z]{2,}")
    @Column(name = "country", nullable = true, length = 64)
    private String country;



    @Pattern(message = "Wrong input provided! We accept: male/female/Not prefer to say" , regexp = "(?:m|M|male|Male|f|F|female|Female|FEMALE|MALE|Not prefer to say)$")
    @Size(min = 1, max = 10, message="Wrong size, must be from 1 to 10 chars")
    @Column(name = "gender", length = 32)
    private String gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }


    @Pattern(message = "Wrong input provided!" ,regexp = "^\\+?[1-9][0-9]{7,14}$")
    @Size(min = 7, max = 16 , message="Wrong size, must be from 7 to 16 chars")
    @Column(name = "phone_number", length = 16)
    private String phoneNumber;



    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9'\\.\\-\\s\\,]+$")
    @Size(min=1, max = 8, message="Wrong size, must be from 1 to 8 chars")
    @Column(name = "house_number", length = 8)
    private String houseNumber;

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'\\.\\-\\s\\,]+$")
    @Size(min = 1, max = 64, message="Wrong size, must be from 1 to 64 chars")
    @Column(name = "street_name", nullable = true, length = 64)
    private String streetName;

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'\\.\\-\\s\\,]+$")
    @Size(min = 1, max = 64, message="Wrong size, must be from 1 to 64 chars")
    @Column(name = "city", nullable = true, length = 64)
    private String city;
//

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'\\.\\-\\s\\,]+$")
    @Size(min = 1, max = 64, message="Wrong size, must be from 1 to 64 chars")
    @Column(name = "state", nullable = true, length = 64)
    private String state;


    @Pattern(message = "Wrong input provided!" , regexp = "(?i)^[a-z0-9][a-z0-9\\- ]{0,10}[a-z0-9]$")
    @Size(min = 1, max = 16, message="Wrong size, must be from 1 to 16 chars")
    @Column(name = "postal_code", nullable = true, length = 16)
    private String postalCode;


    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

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