package com.example.milebo.feature.category.repository;

import com.example.milebo.feature.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByNameIgnoreCase(String cleanName);


//      find by active để UI chỉ hiện danh mục active
    @Query("SELECT c FROM Category c WHERE c.status = true")
    List<Category> findAllActive();

//      generate code để lưu DB
    boolean existsByCode(String code);

//      để check trùng tên và bỏ qua chính nó khi edit trong khi edit category
    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);

}

