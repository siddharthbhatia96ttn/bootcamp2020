package com.example.demo.q2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class q2empmethods {
   @Autowired
   private q2empdata data;

    @GetMapping("/emp")
   public List<q2emp> retrieveAllEmp()
    {
        return data.findAll();

    }

  @GetMapping("/find_one/{Top}")
    public q2emp retrieveOneEmp(@PathVariable int Top)
    {
          q2emp a=  data.find_One(Top);
          if(a==null)
          {
              throw new exception_handel("Top");
          }
         return a;
    }

    @PostMapping("/emp")
    public void createEmp(@Valid @RequestBody q2emp e)
    {
        q2emp saved=data.save_emp(e);
    }

    @DeleteMapping("/del/{id}")
    public void deleteusr(@PathVariable int id)
    {
        q2emp e=data.deleteById(id);
        if(e==null)
        {
            throw new exception_handel("id"+id);
        }
    }

    @PutMapping("/upd/{id}")
    public void saveUpdate(@RequestBody q2emp e,int id)
    {
      data.save(e,id);
    }




    /*@GetMapping("/find_one/{Top}")
    public Resource<q2emp> retrieveOneEmp(@PathVariable int Top)
    {
        q2emp f=data.find_One(Top);
        Resource<q2emp> resource=new Resource<q2emp>(f);
        ControllerLinkBuilder linkTo= linkTo(methodOn(this.getClass()).retrieveAllEmp());
        resource.add(linkTo.withRel("all emp"));
        return resource;
    }*/
}
