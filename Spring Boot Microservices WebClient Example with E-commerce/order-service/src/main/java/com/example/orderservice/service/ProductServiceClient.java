package com.example.orderservice.service;

import com.example.orderservice.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceClient {
    private final WebClient.Builder webClientBuilder;
    private final String productServiceUrl;

    public ProductServiceClient(WebClient.Builder webClientBuilder,@Value("${product.server.url}") String productServiceUrl) {
        this.webClientBuilder = webClientBuilder;
        this.productServiceUrl = productServiceUrl;
    }
    public Mono<ProductEntity> getProductById(String productId){
        return webClientBuilder.build().get()
                .uri(productServiceUrl+"/"+productId)
                .retrieve()
                .bodyToMono(ProductEntity.class);
    }

}
