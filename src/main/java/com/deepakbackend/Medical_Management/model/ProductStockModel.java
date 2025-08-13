package com.deepakbackend.Medical_Management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product_stock")
public class ProductStockModel {
    @Id
    private String id;
    private String productId;
    private String productName;
    private String category;
    private Double price;
    private Integer stock;
    private String userName;
    private String userEmail;

    public ProductStockModel(String productId, String productName, String category, Double price, Integer stock, String userName, String userEmail) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public ProductStockModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
