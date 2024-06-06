package com.example.orderservice.controller;

import com.example.orderservice.service.ProductServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {
    private final ProductServiceClient productServiceClient;

    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("{productId}")
    public Mono<String> createOrder(@PathVariable String productId){
        return productServiceClient.getProductById(productId)
                .map(productEntity -> "Order created for product: "+ productEntity.getName()+" with price "+ productEntity.getPrice());
    }
}
