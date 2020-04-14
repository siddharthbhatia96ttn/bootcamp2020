package com.ecommerce.Ecommerce.services;

import com.ecommerce.Ecommerce.entities.Registration_Details.Customer;
import com.ecommerce.Ecommerce.entities.Registration_Details.User;
import com.ecommerce.Ecommerce.repos.CustomerRepository;
import com.ecommerce.Ecommerce.repos.UserRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDaoService {
    @Autowired
    UserRepository userRepository;

   @Autowired
    CustomerRepository customerRepository;

 /*   public MappingJacksonValue showCustomerData(String emailId)
    {
        Optional<Customer> customer=customerRepository.findByEmailCustomer(emailId);

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id","first_name","middle_name","last_name","contact","is_active");

        //SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("contact");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("userFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(customer);
        mapping.setFilters(filterProvider);
        return mapping;
    }*/
}
