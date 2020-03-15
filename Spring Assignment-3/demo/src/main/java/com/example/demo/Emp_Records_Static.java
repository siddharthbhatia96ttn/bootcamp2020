package com.example.demo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Emp_Records_Static {
    private static int count=0;
    private static List<Emp_POJO_Static> data=new ArrayList<Emp_POJO_Static>();
    public Emp_POJO_Static save_emp_static(Emp_POJO_Static emp)
    {
        if(emp.getRollno()==null)
        {
            emp.setRollno(++count);
        }
        data.add(emp);
        return emp;
    }

    public List<Emp_POJO_Static> findAll()
    {
        return data;
    }
}
