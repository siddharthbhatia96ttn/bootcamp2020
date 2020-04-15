package com.ecommerce.Ecommerce.controller;

import com.ecommerce.Ecommerce.services.CustomerDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerDaoService data;

  /*  @GetMapping("/customer/showData/{emailId}")
    public MappingJacksonValue getProfile(@RequestParam("emailId")String emailId)
    {
        return data.showCustomerData(emailId);
    }*/
}
