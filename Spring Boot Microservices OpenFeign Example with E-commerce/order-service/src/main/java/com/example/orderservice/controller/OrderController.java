package com.example.orderservice.controller;

import com.example.orderservice.entity.ProductEntity;
import com.example.orderservice.service.ProductServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {
    private final ProductServiceClient productServiceClient;

    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("{productId}")
    public String createOrder(@PathVariable String productId){
        ProductEntity product = productServiceClient.getProductById(productId);
        return "Order created for product: "+ product.getName()+" with price: "+product.getPrice();
    }
}
