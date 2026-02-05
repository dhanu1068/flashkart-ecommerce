package com.example.flashkart.service;

import com.example.flashkart.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products=new ArrayList<>();

    private long idCounter=1;

    public Product addProduct(Product product){
        product.setId(idCounter++);
        products.add(product);
        return product;
    }

    public Product getProductById(Long id){
        return products.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean isDealExpired(Product product){
        return LocalDateTime.
                now().
                isAfter(product.getDealExpiryTime());
    }

}
