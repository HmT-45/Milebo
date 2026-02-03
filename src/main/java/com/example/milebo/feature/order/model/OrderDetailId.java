package com.example.milebo.feature.order.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    private String orderId;
    private String productId;
}
