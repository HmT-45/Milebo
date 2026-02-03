package com.example.milebo.feature.product.repository;

import com.example.milebo.feature.product.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /* ====== COMMON ====== */

    boolean existsByCode(String code);
    boolean existsByCategoryId(Long categoryId);

    /* ====== ADMIN ====== */

    // Admin xem tất cả (kể cả INACTIVE)
    @Query("SELECT p FROM Product p")
    List<Product> findAllForAdmin();

    /* ====== CLIENT ====== */

    // Client chỉ thấy ACTIVE
    @Query("""
    SELECT p
    FROM Product p
    WHERE p.status = true
    ORDER BY p.category.id, p.id DESC
    """)
    List<Product> findAllActive();

    // Client xem theo category code
    @Query("""
        SELECT p
        FROM Product p
        WHERE p.status = true
          AND p.category.status = true
          AND p.category.code = :code
    """)
    List<Product> findActiveByCategoryCode(String code);
//   client xem top 6 sản phẩm
    @Query("""
    SELECT p
    FROM Product p
    WHERE p.status = true
      AND p.category.status = true
      AND p.category.id = :categoryId
    ORDER BY p.id DESC
     """)
    List<Product> findTop6ByCategory(
            @Param("categoryId") Long categoryId,
            Pageable pageable
    );
}

