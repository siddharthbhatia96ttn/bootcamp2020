package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class plane_loose implements  vehicle {
    @Override
    public void move() {
        System.out.println("I am on a plane");
    }
}