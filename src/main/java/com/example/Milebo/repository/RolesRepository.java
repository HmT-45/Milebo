package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository
        extends JpaRepository<Roles, String> {
}
