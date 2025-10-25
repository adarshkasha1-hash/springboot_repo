package com.example.demo.mapper;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category convertCategoryToCategoryDto(CategoryDto category) {

        Category categoryEntity = new Category();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());

        return categoryEntity;

    }

    public static CategoryDto convertCategoryToCategoryDto(Category category) {
      if(category == null) {
          return null;
      }
      CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProducts(category.getProducts().stream().
            map(ProductMapper::entityToDto).toList());
            return categoryDto;
    }

}
