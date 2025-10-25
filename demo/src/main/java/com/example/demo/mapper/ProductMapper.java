package com.example.demo.mapper;

import com.example.demo.Dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public class ProductMapper {

    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());
            productDto.setCategoryId(product.getCategory().getId());
            return productDto;
    }


    public static Product dtoToEntity(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        return product;
    }
}
