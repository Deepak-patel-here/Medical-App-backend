package com.deepakbackend.Medical_Management.model;

public class ProductMapping {
    private String productName;
    private Double productPrice;
    private String category;
    private Integer stock;
    private String image;

    public String getProductName() {
        return productName;
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

    public ProductMapping(String productName, Double productPrice, String category, Integer stock, String image) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
        this.stock = stock;
        this.image = image;
    }

    public ProductMapping() {
    }
}
