package com.deepakbackend.Medical_Management.repository;

import com.deepakbackend.Medical_Management.model.ProductStockModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<ProductStockModel,String> {
    List<ProductStockModel> findProductStockByUserEmail(String userEmail);
}
