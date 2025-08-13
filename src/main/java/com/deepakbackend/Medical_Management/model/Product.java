package com.deepakbackend.Medical_Management.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {
    @Id
    private String id;
    private String productId="";
    private String productName="";
    private Double productPrice=null;
    private String category="";
    private Integer stock=null;
    private String image ="";

    public String getProductName() {
        return productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product(String productId,String productName, Double productPrice, String category, Integer stock, String image) {
        this.productId=productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
        this.stock = stock;
        this.image = image;
    }

    public Product() {
    }
}
