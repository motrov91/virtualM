package com.example.ingmanuel.mercaexpress.Models;

import java.io.Serializable;

public class ProductsModel implements Serializable {

    private int idProduct;
    private int idcategory;
    private int productImage;
    private String productName;
    private String productPrice;
    private String productDescription;
    private String promotion;
    private String discount;

    public ProductsModel() {
    }

    public ProductsModel(int idProduct, int category, int productImage, String productName, String productPrice, String productDescription, String promotion, String discount) {
        this.idProduct = idProduct;
        this.idcategory = category;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.promotion = promotion;
        this.discount = discount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCategory() {
        return idcategory;
    }

    public void setCategory(int category) {
        this.idcategory = category;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}