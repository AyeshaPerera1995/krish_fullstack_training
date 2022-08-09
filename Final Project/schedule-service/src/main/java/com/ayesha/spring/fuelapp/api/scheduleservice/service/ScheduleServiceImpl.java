package com.ayesha.spring.fuelapp.api.scheduleservice.service;

import com.ayesha.spring.fuelapp.api.models.Order;
import com.ayesha.spring.fuelapp.api.scheduleservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;

    //update order object
    @Override
    public Order save(Order order) {
        return scheduleRepository.save(order);
    }

    @Override
    public Order findById(String id) {
        Optional<Order> order = scheduleRepository.findById(id);

        if(order.isPresent()) {
           return order.get();
        }else {
            return new Order();
        }
    }

    @Override
    public Order updateOrderDateAndStatus(String id, String date) {
        Optional<Order> order = scheduleRepository.findById(id);

        if(order.isPresent()) {
            order.get().setScheduled_date(LocalDate.parse(date));
            order.get().setStatus("Delivery Scheduled");
            save(order.get());
            return order.get();
        }else {
            return new Order();
        }
    }

    @Override
    public List<Order> findAll() {
        return scheduleRepository.findAll();
    }

}
