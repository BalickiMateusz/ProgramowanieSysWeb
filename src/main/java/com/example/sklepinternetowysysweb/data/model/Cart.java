package com.example.sklepinternetowysysweb.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "\"Cart\"")
public class Cart {
    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "total_weight")
    private Float totalWeight;

    @NotNull(message = "Can not be empty!")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice =  BigDecimal.valueOf(totalPrice)
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .floatValue();

    }

    public Float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Float totalWeight) {
        this.totalWeight = BigDecimal.valueOf(totalWeight)
                .setScale(2, BigDecimal.ROUND_HALF_DOWN)
                .floatValue();
    }

}