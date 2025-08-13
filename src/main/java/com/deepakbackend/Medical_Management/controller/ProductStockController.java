package com.deepakbackend.Medical_Management.controller;


import com.deepakbackend.Medical_Management.model.ProductStockModel;
import com.deepakbackend.Medical_Management.service.StockService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductStockController {

    @Autowired
    private StockService service;
    @GetMapping("/stock-product")
    public ResponseEntity<?>  getAllProductStock(@RequestBody  String email){
        return ResponseEntity.ok(service.getStockByEmail(email));
    }

    @PostMapping("/add_product_stock")
    public ResponseEntity<?> addProductToUserStock(@RequestBody ProductStockModel stockModel){
        return ResponseEntity.ok(service.addProduct(stockModel));
    }

    @PutMapping("/update_product_stock")
    public ResponseEntity<?>  update(@RequestBody ProductStockModel model){
        return ResponseEntity.ok(service.updateUser(model));
    }

    @DeleteMapping("/delete_product_stock")
    public ResponseEntity<?> deleteProductStock(@RequestBody  String id){
        return ResponseEntity.ok(service.deleteStock(id));
    }
}
