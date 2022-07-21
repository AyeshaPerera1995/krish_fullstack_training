package com.ayesha.rentcloud.commons.model;

import sun.java2d.loops.CompositeType;

import javax.persistence.*;

//Mark as Entity, because this is the class we are going to deal with DB
@Entity
@Table(name="customer")
public class Customer {

    @Id    //mark this as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto generated value
    int id;

    String firstName;
    String lastName;
    String dlNumber;
    String zipCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
