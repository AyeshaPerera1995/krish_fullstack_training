package com.ayesha.spring.fuelapp.api.allocationservice.controller;
import com.ayesha.spring.fuelapp.api.allocationservice.service.AllocationService;
import com.ayesha.spring.fuelapp.api.models.Allocated_Stock;
import com.ayesha.spring.fuelapp.api.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/allocations")
@CrossOrigin(origins = "*")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @PostMapping
    public Allocated_Stock save(@RequestBody Allocated_Stock allocated_stock){
        return allocationService.save(allocated_stock);
    }

    @GetMapping(value = "/total_allocated_stock/{fuel_type}")
    public int getTotalAllocatedStock(@PathVariable String fuel_type){
        return allocationService.getTotalAllocatedStock(fuel_type);
    }

    @GetMapping(value = "/main_stock/{fuel_type}")
    public int getMainStock(@PathVariable String fuel_type) {
        System.out.println("in controller");
        System.out.println(allocationService.getMainStock(fuel_type));
        return allocationService.getMainStock(fuel_type);
    }

    @GetMapping(value = "/usable_stock/{fuel_type}")
    public int getUsableStock(@PathVariable String fuel_type){
       return allocationService.getUsableStock(fuel_type);
    }

}
