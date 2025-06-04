package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> filterByCategory(String category) {
        return productRepo.findByCategory(category);
    }

    public List<Product> filterByPriceRange(Double min, Double max) {
        return productRepo.findByPriceBetween(min, max);
    }

    public List<Product> searchByName(String keyword) {
        return productRepo.findByNameContainingIgnoreCase(keyword);
    }
}
