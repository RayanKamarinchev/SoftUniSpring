package com.example.mvcdemo.repository;

import com.example.mvcdemo.domain.entities.Category;
import com.example.mvcdemo.domain.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryName name);
}
