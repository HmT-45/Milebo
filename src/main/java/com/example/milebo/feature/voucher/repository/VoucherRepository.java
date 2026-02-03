package com.example.milebo.feature.voucher.repository;

import com.example.milebo.feature.voucher.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository
        extends JpaRepository<Voucher, String> {
}

