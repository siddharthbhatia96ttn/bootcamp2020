package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext q3=SpringApplication.run(DemoApplication.class, args);
		traveller_loose traveller=q3.getBean(traveller_loose.class);
		traveller.start_journey();
		System.out.println(traveller.price);
	}

}
