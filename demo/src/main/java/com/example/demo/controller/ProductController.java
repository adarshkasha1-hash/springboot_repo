package com.example.demo.controller;

import com.example.demo.Dto.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    //createproduct
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto productDto) {
        ProductDto save = productService.save(productDto);
        return save;
    }

    @GetMapping("/findAll")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable  Long id) {
        return productService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String delById(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto productDto,@PathVariable int id) {
        ProductDto update = productService.update(productDto,id);
        return update;
    }
}
