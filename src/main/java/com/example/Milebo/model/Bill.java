package com.example.Milebo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Milebo.model.Users;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    private LocalDate date;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;
}