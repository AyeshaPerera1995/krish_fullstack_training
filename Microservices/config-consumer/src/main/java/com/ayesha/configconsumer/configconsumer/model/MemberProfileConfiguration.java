package com.ayesha.configconsumer.configconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileConfiguration {

    @Autowired
    Environment environment;
    // you connect the env and get the service properties from bootstrap.yml file.
    // So bootstrap.yml is config, hey go and ask from localhost 8191 port.
    // It goes to my config-server (project) application.yml and get data from GitHub.
    // give to membership service.

    public String getDefaultModel(){
        return environment.getProperty("vehicle.default.model");
        //                              This called from .yml file
    }

    public String getMinRentPeriod(){
        return environment.getProperty("member.rent.min");
    }

}
