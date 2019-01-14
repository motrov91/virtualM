package com.example.ingmanuel.mercaexpress.Models;

public class CarModel {

    String name;
    String Description;
    int price;
    int imageProduct;
    int cantidad;

    public CarModel() {}

    public CarModel(String name, String description, int price, int imageProduct, int cantidad) {
        this.name = name;
        Description = description;
        this.price = price;
        this.imageProduct = imageProduct;
        this.cantidad = cantidad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(int imageProduct) {
        this.imageProduct = imageProduct;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
