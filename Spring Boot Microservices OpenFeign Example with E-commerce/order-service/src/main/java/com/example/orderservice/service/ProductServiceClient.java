package com.example.orderservice.service;

import com.example.orderservice.entity.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "${product.service.url}")
public interface ProductServiceClient {
    @GetMapping("{productId}")
    ProductEntity getProductById(@PathVariable String productId);
}
