package com.example.milebo.feature.role.repository;

import com.example.milebo.feature.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository
        extends JpaRepository<Role, String> {
}

