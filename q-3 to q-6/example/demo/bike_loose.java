package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class bike_loose implements  vehicle {
    @Override
    public void move() {
        System.out.println("I am on a bike");
    }
}
