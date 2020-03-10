package com.example.demo.q1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class as2q1 {
    @GetMapping(path="/Welcome-Page")
    public String welcome(){
        return "Welcome to Spring Boot";
    }
}
