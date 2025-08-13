package com.deepakbackend.Medical_Management.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
@Document("order")
public class OrderModel {
    @Id
    private String id;
    private String orderId;
    private String userEmail;
    private String productId;
    private boolean isApproved;
    private Integer quantity;
    private Instant dateOfOrderCreated;
    private Double price;
    private String productName;
    private String message;
    private String category;

    public OrderModel(String orderId, String userEmail, String productId, boolean isApproved, Integer quantity, Instant dateOfOrderCreated, Double price, String productName, String message, String category) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.productId = productId;
        this.isApproved = isApproved;
        this.quantity = quantity;
        this.dateOfOrderCreated = dateOfOrderCreated;
        this.price = price;
        this.productName = productName;
        this.message = message;
        this.category = category;
    }

    public OrderModel() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Instant getDateOfOrderCreated() {
        return dateOfOrderCreated;
    }

    public void setDateOfOrderCreated(Instant dateOfOrderCreated) {
        this.dateOfOrderCreated = dateOfOrderCreated;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
