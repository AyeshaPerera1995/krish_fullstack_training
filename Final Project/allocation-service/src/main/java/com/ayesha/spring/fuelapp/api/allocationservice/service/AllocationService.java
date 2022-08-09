package com.ayesha.spring.fuelapp.api.allocationservice.service;

import com.ayesha.spring.fuelapp.api.models.Allocated_Stock;

import java.util.List;

public interface AllocationService {

    Allocated_Stock save(Allocated_Stock allocated_stock);

    List<Allocated_Stock> findAll();

    int getTotalAllocatedStock(String fuel_type);

    int getMainStock(String fuel_type);

    int getUsableStock(String fuel_type);

}
