package com.example.Milebo.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BillDetailsId implements Serializable {
    private String billId;
    private String productId;
}