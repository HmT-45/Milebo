package com.example.milebo.feature.user.repository;

import com.example.milebo.feature.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {

    // Khách hàng mới hôm nay (role = USER)
    @Query(value = """
        SELECT COUNT(*)
        FROM Users
        WHERE role_id = 2
          AND CAST(created_date AS date) = CAST(GETDATE() AS date)
    """, nativeQuery = true)
    Long countNewCustomersToday();
}
