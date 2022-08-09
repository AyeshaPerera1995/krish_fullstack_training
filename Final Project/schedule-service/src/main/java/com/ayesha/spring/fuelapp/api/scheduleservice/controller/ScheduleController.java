package com.ayesha.spring.fuelapp.api.scheduleservice.controller;

import com.ayesha.spring.fuelapp.api.models.Order;
import com.ayesha.spring.fuelapp.api.scheduleservice.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/services/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/update")
    public Order updateOrderDateAndStatus(@RequestParam String id,@RequestParam String date){
        return scheduleService.updateOrderDateAndStatus(id,date);
    }

    @GetMapping
    public List<Order> getOrders(){
        return scheduleService.findAll();
    }


}
