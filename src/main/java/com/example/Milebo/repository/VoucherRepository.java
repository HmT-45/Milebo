package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository
        extends JpaRepository<Voucher, String> {
}
