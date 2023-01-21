package com.example.sklepinternetowysysweb.data.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9'\\.\\-\\s\\,]+$")
    @Size(min=1, max = 8, message="Wrong size, must be from 1 to 8 chars")
    @NotNull(message="Can not be empty!")
    @Column(name = "house_number", length = 8)
    private String houseNumber;

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'\\.\\-\\s\\,]+$")
    @Size(min = 1, max = 64, message="Wrong size, must be from 1 to 64 chars")
    @NotNull(message="Can not be empty!")
    @Column(name = "street_name", nullable = false, length = 64)
    private String streetName;

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'\\.\\-\\s\\,]+$")
    @Size(min = 1, max = 64, message="Wrong size, must be from 1 to 64 chars")
    @NotNull(message="Can not be empty!")
    @Column(name = "city", nullable = false, length = 64)
    private String city;

    @Pattern(message = "Wrong input provided!" , regexp ="[A-Za-z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'\\.\\-\\s\\,]+$")
    @Size(min = 1, max = 64, message="Wrong size, must be from 1 to 64 chars")
    @NotNull(message="Can not be empty!")
    @Column(name = "state", nullable = false, length = 64)
    private String state;

    @Pattern(message = "Wrong input provided!" , regexp = "(?i)^[a-z0-9][a-z0-9\\- ]{0,10}[a-z0-9]$")
    @Size(min = 1, max = 16, message="Wrong size, must be from 1 to 16 chars")
    @NotNull(message="Can not be empty!")
    @Column(name = "postal_code", nullable = false, length = 16)
    private String postalCode;

    @Size(min = 4, max = 64, message="Wrong size, must be from 4 to 64 chars")
    @Pattern(message = "Wrong input provided!" , regexp = "[a-zA-Z]{2,}")
    @NotNull(message="Can not be empty!")
    @Column(name = "country", nullable = false, length = 64)
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}