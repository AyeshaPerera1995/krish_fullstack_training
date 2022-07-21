package com.ayesha.rentcloud.profileservice.controller;

import com.ayesha.rentcloud.commons.model.Customer;
import com.ayesha.rentcloud.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers",method = RequestMethod.POST)
    // We set this by permission level. If user has permission to create_profile(in PERMISSION table), then only user can create a profile...
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }



    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer fetch(@PathVariable(value = "id") int customerid) {
        return customerService.fetchById(customerid);
    }



    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    // We set this by permission level. If anyone has read permission that user can read profiles...
    //@PreAuthorize("hasAuthority('read_profile')")
    // We can set this by role(Role table).
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }

}
