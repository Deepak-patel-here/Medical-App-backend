package com.deepakbackend.Medical_Management.service;

import com.deepakbackend.Medical_Management.model.ProductStockModel;
import com.deepakbackend.Medical_Management.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {


    @Autowired
    private StockRepository repository;

    public List<ProductStockModel> getStockByEmail(String email){
        return repository.findProductStockByUserEmail(email);
    }

    public ProductStockModel addProduct(ProductStockModel stock){
        return repository.save(stock);
    }

    public String updateUser(ProductStockModel stock){
        ProductStockModel productStockModel = repository.findById(stock.getId()).orElseThrow();
        productStockModel.setProductId(stock.getProductId());
        productStockModel.setProductName(stock.getProductName());
        productStockModel.setStock(stock.getStock());
        productStockModel.setCategory(stock.getCategory());
        productStockModel.setPrice(stock.getPrice());
        productStockModel.setUserEmail(stock.getUserEmail());
        productStockModel.setUserName(stock.getUserName());

        repository.save(productStockModel);
        return "successfully Updated";
    }

    public String deleteStock(String id){
        repository.deleteById(id);
        return "Successfully deleted";
    }
}
