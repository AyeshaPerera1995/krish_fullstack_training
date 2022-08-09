package com.ayesha.spring.fuelapp.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String station_name; //This means the gas station city
    private int fuel_capasity;
    private String fuel_type;
    private LocalDate scheduled_date;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public int getFuel_capasity() {
        return fuel_capasity;
    }

    public void setFuel_capasity(int fuel_capasity) {
        this.fuel_capasity = fuel_capasity;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getScheduled_date() {
        return scheduled_date;
    }

    public void setScheduled_date(LocalDate scheduled_date) {
        this.scheduled_date = scheduled_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", station_name='" + station_name + '\'' +
                ", fuel_capasity=" + fuel_capasity +
                ", fuel_type='" + fuel_type + '\'' +
                ", scheduled_date=" + scheduled_date +
                ", status='" + status + '\'' +
                '}';
    }
}

