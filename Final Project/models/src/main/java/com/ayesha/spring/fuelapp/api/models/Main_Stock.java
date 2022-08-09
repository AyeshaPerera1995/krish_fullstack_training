package com.ayesha.spring.fuelapp.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "main_stocks")
public class Main_Stock {

    @Id
    private String id;
    private String fuel_type;
    private int available_stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public int getAvailable_stock() {
        return available_stock;
    }

    public void setAvailable_stock(int available_stock) {
        this.available_stock = available_stock;
    }

    @Override
    public String toString() {
        return "Main_Stock{" +
                "id='" + id + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", available_stock=" + available_stock +
                '}';
    }
}
