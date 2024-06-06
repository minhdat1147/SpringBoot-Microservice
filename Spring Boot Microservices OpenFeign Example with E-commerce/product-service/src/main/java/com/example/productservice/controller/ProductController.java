package com.example.productservice.controller;

import com.example.productservice.entity.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    @GetMapping("{id}")
    public ProductEntity getProduct(@PathVariable String id){
        return new ProductEntity(id, "Sample Product", 99.99);
    }
}
