package com.example.project.entity;

public class Car extends Entity{
    private String brand;
    private String model;
    private boolean available;
    private float dayPrice;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public float getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(float dayPrice) {
        this.dayPrice = dayPrice;
    }
}
