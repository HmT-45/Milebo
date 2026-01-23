package com.example.Milebo.repository;

import com.example.Milebo.model.Bill;
import com.example.Milebo.model.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository
        extends JpaRepository <Bill, String> {
}
