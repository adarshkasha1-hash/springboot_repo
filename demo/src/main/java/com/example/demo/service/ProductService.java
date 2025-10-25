package com.example.demo.service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public ProductDto save(ProductDto productDto) {
        Category categoryNotFound = categoryRepo.findById((long) productDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = ProductMapper.dtoToEntity(productDto, categoryNotFound);
        Product save = productRepo.save(product);
        return ProductMapper.entityToDto(save);
    }


    public List<ProductDto> findAll() {

        return productRepo.findAll().stream().map(ProductMapper::entityToDto).toList();
    }

    public ProductDto findById(Long id) {

       Product product= productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.entityToDto(product);

    }

    public String deleteById(Long id) {
        productRepo.deleteById(id);
        return "Deleted Product Successfully"+id;
    }

    public ProductDto update(ProductDto productDto, int id) {
        Product product = productRepo.findById((long) id).orElseThrow(() -> new RuntimeException("Not FOund id" + id));
        Category cat=categoryRepo.findById((long) id).orElseThrow(()->new RuntimeException("NotFOundd"));
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(cat);
        productRepo.save(product);
        productRepo.save(product);
        return ProductMapper.entityToDto(product);
        }

}
