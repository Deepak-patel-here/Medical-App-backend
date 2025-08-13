package com.deepakbackend.Medical_Management.controller;

import com.deepakbackend.Medical_Management.model.Product;
import com.deepakbackend.Medical_Management.model.ProductMapping;
import com.deepakbackend.Medical_Management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody ProductMapping productMapping){
        return service.addProduct(productMapping);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable String id,@RequestBody ProductMapping productMapping){
        return service.updateProduct(id,productMapping);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }
}
