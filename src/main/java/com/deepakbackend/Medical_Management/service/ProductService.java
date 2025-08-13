package com.deepakbackend.Medical_Management.service;

import com.deepakbackend.Medical_Management.model.Product;
import com.deepakbackend.Medical_Management.model.ProductMapping;
import com.deepakbackend.Medical_Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(ProductMapping productMapping) {
        String productId = UUID.randomUUID().toString();
        Product product = new Product(
                productId,
                productMapping.getProductName(),
                productMapping.getProductPrice(),
                productMapping.getCategory(),
                productMapping.getStock(),
                productMapping.getImage()
        );
        return  repository.save(product);
    }

    public Product updateProduct(String id,ProductMapping productMapping){
        Product product=repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setProductName(productMapping.getProductName());
        product.setProductPrice(productMapping.getProductPrice());
        product.setCategory(productMapping.getCategory());
        product.setStock(productMapping.getStock());
        product.setImage(productMapping.getImage());

        return repository.save(product);

    }

    public String deleteProduct(String id){
        repository.deleteById(id);
        return "product deleted successfully";
    }
}
