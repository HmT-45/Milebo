package com.example.milebo.feature.discount.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Discount")
public class Discount {

    @Id
    @Column(length = 10)
    private String id;

    @Column(nullable = false, length = 150)
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean status;

    private Integer type; // 1: %, 2: tiền

    @Column(precision = 10, scale = 2)
    private BigDecimal value;
}

