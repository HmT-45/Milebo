package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.CartDetail;
import com.example.Milebo.model.CartDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository
        extends JpaRepository<CartDetail, CartDetailId> {
}
