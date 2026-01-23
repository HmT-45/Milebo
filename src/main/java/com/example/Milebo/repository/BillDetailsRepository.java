package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.BillDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDetailsRepository
        extends JpaRepository <BillDetails, BillDetailsId> {
}
