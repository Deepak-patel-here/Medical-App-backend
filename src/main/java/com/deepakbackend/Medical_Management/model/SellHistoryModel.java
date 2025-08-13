package com.deepakbackend.Medical_Management.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("sell_history")
public class SellHistoryModel {
    @Id
    private String id;
    private String sellId;
    private String productId;
    private Integer quantity;
    private Instant dateSell;
    private Double amount;
    private Double price;
    private String productName;
    private String userEmail;
    private String userName;

    public SellHistoryModel(String sellId, String productId, Integer quantity, Instant dateSell, Double amount, Double price, String productName, String userEmail, String userName) {
        this.sellId = sellId;
        this.productId = productId;
        this.quantity = quantity;
        this.dateSell = dateSell;
        this.amount = amount;
        this.price = price;
        this.productName = productName;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public SellHistoryModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Instant getDateSell() {
        return dateSell;
    }

    public void setDateSell(Instant dateSell) {
        this.dateSell = dateSell;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
