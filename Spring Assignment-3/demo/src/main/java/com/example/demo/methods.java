package com.example.demo;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class methods {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private Emp_Records pj;
    @Autowired
    private  Emp_Records_Static pj2;

   @GetMapping(path="/good-morning")
    public String goodmorningI18(@RequestHeader(name="Accept-Language",required=false) Locale locale)
    {
          return messageSource.getMessage("good.morning.message",null,locale);
    }

    @GetMapping(path="/good-morning-custom")
    public String goodmorningI18custom(@RequestHeader(name="Accept-Language",required=false) Locale locale,@RequestParam(name = "na") String na)
    {
        return messageSource.getMessage("good.morning.message",new Object[]{na},locale);
    }

    @GetMapping(path="/show-data")
    public List<Emp_POJO> showEmp()
    {
        return pj.findAll();
    }

    @PostMapping(path="/add-data")
    public void createUsr(@RequestBody Emp_POJO emp)
    {
        Emp_POJO save=pj.save_emp(emp);
    }

    @PostMapping(path="/add-data-static")
    public void createstaticUsr(@RequestBody Emp_POJO_Static emp)
    {
        Emp_POJO_Static save=pj2.save_emp_static(emp);
    }

    @GetMapping(path="/show-data-static")
    public List <Emp_POJO_Static> showStaticUsr()
    {
        return pj2.findAll();
    }
    @GetMapping(path="/show-data-dynamic")
    public MappingJacksonValue showDynamicUsr()
    {
        Emp_Pojo_Dynamic epd=new Emp_Pojo_Dynamic(1,"Siddharth",23,"123");

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("rollno1","username1","age1");

        FilterProvider filters=new SimpleFilterProvider().addFilter("Some bean filter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(epd);

        mapping.setFilters(filters);

        return mapping;
    }
    //q-10
    //uri
    @GetMapping(path="v1/person")
    public Versioning_Person personV1()
    {
        return new Versioning_Person("Siddharth Bhatia");
    }
    @GetMapping(path="v2/person")
    public Versioning_Person2 personV2()
    {
        return new Versioning_Person2(new Versioning("Siddharth", "Bhatia"));
    }
    //Request Parameter
    @GetMapping(path="person/param",params="version=1")
    public Versioning_Person paramV1()
    {
        return new Versioning_Person("Siddharth Bhatia");
    }
    @GetMapping(path="person/param",params="version=2")
    public Versioning_Person2 paramV2()
    {
        return new Versioning_Person2(new Versioning("Siddharth", "Bhatia"));
    }
    //Custom Header Versioning
    @GetMapping(path="person/header",headers="X-API-VERSION=1")
    public Versioning_Person headerV1()
    {
        return new Versioning_Person("Siddharth Bhatia");
    }
    @GetMapping(path="person/header",headers="X-API-VERSION=2")
    public Versioning_Person2 headerV2()
    {
        return new Versioning_Person2(new Versioning("Siddharth", "Bhatia"));
    }
    //MimeType
    @GetMapping(path="person/mime",produces="application/v1+json")
    public Versioning_Person mimeV1()
    {
        return new Versioning_Person("Siddharth Bhatia");
    }
    @GetMapping(path="person/mime",produces="application/v2+json")
    public Versioning_Person2 mimeV2()
    {
        return new Versioning_Person2(new Versioning("Siddharth", "Bhatia"));
    }

    //Haetos
    @GetMapping(path="hateos/{id}")
    public Emp_POJO retrieveoneEmp(@PathVariable int id)
    {
        Emp_POJO a=pj.find_one(id);
        return a;
    }
}
