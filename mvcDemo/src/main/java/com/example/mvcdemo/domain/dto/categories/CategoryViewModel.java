package com.example.mvcdemo.domain.dto.categories;

import com.example.mvcdemo.domain.enums.CategoryName;

public class CategoryViewModel {
    private Long id;
    private CategoryName name;

    private String description;

    public CategoryViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
