package com.example.Milebo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Voucher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String code;

    private Integer value;

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer quantity;
}
