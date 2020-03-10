package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class traveller_loose {
    int price=1000;
    @Autowired
    vehicle v;

   public void setV(vehicle v) {
        this.v = v;
    }
    public void  start_journey()
    {
        v.move();
    }
}