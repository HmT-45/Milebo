package com.example.Milebo.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CartDetailId implements Serializable {

    private String cartId;
    private String productId;
}