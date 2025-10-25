package com.example.demo.service;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.convertCategoryToCategoryDto(categoryDto);
        categoryRepo.save(category);
        return CategoryMapper.convertCategoryToCategoryDto(category);
    }

    public List<CategoryDto> findAll() {
        return categoryRepo.findAll().stream().map(CategoryMapper::convertCategoryToCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        Category cat = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return CategoryMapper.convertCategoryToCategoryDto(cat);
    }

    public String deleteById(Long id) {
        categoryRepo.deleteById(id);
        return "Deleted Category Successfully"+id;
    }
}
