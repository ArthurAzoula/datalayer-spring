package com.azoulux.dataLayer.service;

import com.azoulux.dataLayer.model.Product;
import com.azoulux.dataLayer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public Iterable<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> getProductByCategoryName(String name) {
        return productRepository.findByCategoriesName(name);
    }
}
