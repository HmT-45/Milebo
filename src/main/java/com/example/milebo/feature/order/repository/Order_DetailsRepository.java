package com.example.milebo.feature.order.repository;

import com.example.milebo.feature.order.model.OrderDetail;
import com.example.milebo.feature.order.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_DetailsRepository
        extends JpaRepository <OrderDetail, OrderDetailId> {
}

