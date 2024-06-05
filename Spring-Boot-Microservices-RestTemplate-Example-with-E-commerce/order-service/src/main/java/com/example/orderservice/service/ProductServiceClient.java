package com.example.orderservice.service;

import com.example.orderservice.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceClient {
    private final RestTemplate restTemplate;
    private final  String productServiceUrl;
    public ProductServiceClient(RestTemplate restTemplate, @Value("${product.service.url}") String productServiceUrl){
        this.restTemplate = restTemplate;
        this.productServiceUrl = productServiceUrl;
    }
    public ProductEntity getProductById(String productId){
        return restTemplate.getForObject(productServiceUrl+"/"+productId,ProductEntity.class);
    }

}
