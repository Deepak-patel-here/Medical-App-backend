package com.deepakbackend.Medical_Management.repository;

import com.deepakbackend.Medical_Management.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
