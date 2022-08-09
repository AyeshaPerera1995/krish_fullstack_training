package com.ayesha.spring.fuelapp.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "allocated_stocks")
public class Allocated_Stock {

    @Id
    private String id;
    private String order_id;
    private int allocated_stock;
    private String fuel_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAllocated_stock() {
        return allocated_stock;
    }

    public void setAllocated_stock(int allocated_stock) {
        this.allocated_stock = allocated_stock;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Allocated_Stock{" +
                "id='" + id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", allocated_stock=" + allocated_stock +
                ", fuel_type='" + fuel_type + '\'' +
                '}';
    }
}
