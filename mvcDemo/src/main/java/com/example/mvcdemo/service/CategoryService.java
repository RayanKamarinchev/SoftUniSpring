package com.example.mvcdemo.service;

import com.example.mvcdemo.domain.dto.categories.CategoryViewModel;
import com.example.mvcdemo.domain.enums.CategoryName;
import com.example.mvcdemo.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public CategoryViewModel findByName(CategoryName name) {
        var category = categoryRepository.findByName(name);
        return modelMapper.map(category, CategoryViewModel.class);
    }
}
