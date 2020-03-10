package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class car_loose implements  vehicle {
    @Override
    public void move() {
        System.out.println("I am in a car");
    }
}
