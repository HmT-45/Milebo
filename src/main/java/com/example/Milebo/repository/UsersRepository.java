package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository
        extends JpaRepository<Users, String> {
}
