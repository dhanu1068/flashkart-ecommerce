package com.example.flashkart.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class Product {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;


    @Positive(message = "Price must be greater than zero")
    private double price;

    @Positive(message = "Stock quantity must be greater than zero")
    private int stockQuantity;

    @NotNull(message = "Deal expiry time is required")
    @Future(message = "Deal expiry time must be in the future")
    private LocalDateTime dealExpiryTime;


    public Product(){

    }

}
