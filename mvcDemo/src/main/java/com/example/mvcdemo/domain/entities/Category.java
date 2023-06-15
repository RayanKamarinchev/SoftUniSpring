package com.example.mvcdemo.domain.entities;

import com.example.mvcdemo.domain.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}