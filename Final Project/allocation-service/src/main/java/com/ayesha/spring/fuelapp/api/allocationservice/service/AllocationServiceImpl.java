package com.ayesha.spring.fuelapp.api.allocationservice.service;

import com.ayesha.spring.fuelapp.api.allocationservice.repository.AllocationRepository;
import com.ayesha.spring.fuelapp.api.models.Allocated_Stock;
import com.ayesha.spring.fuelapp.api.models.Main_Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService{

    @Autowired
    AllocationRepository allocationRepository;

    private final MongoTemplate mongoTemplate;

    public AllocationServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Allocated_Stock save(Allocated_Stock allocated_stock) {
        return allocationRepository.save(allocated_stock);
    }

    @Override
    public List<Allocated_Stock> findAll() {
        return allocationRepository.findAll();
    }

    @Override
    public int getTotalAllocatedStock(String fuel_type) {
        Query query = new Query()
                .addCriteria(Criteria.where("fuel_type").is(fuel_type));

        List<Allocated_Stock> allocated_stocks = mongoTemplate.find(query,Allocated_Stock.class);
        int total= allocated_stocks.stream().mapToInt(Allocated_Stock::getAllocated_stock).sum();
        System.out.println("total allocated stock: "+total);
        return total;
    }

    @Override
    public int getMainStock(String fuel_type) {
        Query query = new Query()
                .addCriteria(Criteria.where("fuel_type").is(fuel_type));

        Main_Stock main_stock = mongoTemplate.findOne(query,Main_Stock.class);
        System.out.println("total main stock: "+main_stock.getAvailable_stock());
        return  main_stock.getAvailable_stock();
    }

    public int getUsableStock(String fuel_type){
        int usable_stock = getMainStock(fuel_type) - getTotalAllocatedStock(fuel_type);
        System.out.println("total usable stock: "+usable_stock);
        return usable_stock;
    }

}
