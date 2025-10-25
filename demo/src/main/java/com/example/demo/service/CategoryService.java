package com.example.demo.service;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.convertCategoryToCategoryDto(categoryDto);
        categoryRepo.save(category);
        return CategoryMapper.convertCategoryToCategoryDto(category);
    }

}
