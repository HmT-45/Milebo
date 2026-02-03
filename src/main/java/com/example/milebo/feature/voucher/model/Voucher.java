package com.example.milebo.feature.voucher.model;

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
@Table(name = "Voucher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    @Id
    @Column(length = 10)
    private String id;

    @Column(unique = true, nullable = false, length = 20)
    private String code;

    private Integer value;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer quantity;

    @Column(precision = 12, scale = 2)
    private BigDecimal minOrderValue;
}


