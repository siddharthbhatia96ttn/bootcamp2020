package com.example.demo;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class Emp_Records {
    public static int user=3;
    private static List<Emp_POJO> data=new ArrayList<>();
    static
    {
        data.add(new Emp_POJO(1,"Siddharth",23));
        data.add(new Emp_POJO(2,"Mohan",25));
        data.add(new Emp_POJO(3,"Praveen",26));
    }

    public List<Emp_POJO> findAll()
    {
        return data;
    }

    public Emp_POJO save_emp(Emp_POJO emp)
    {
        if(emp.getId()==null)
        {
             emp.setId(++user);
        }
        data.add(emp);
        return emp;
    }
    public Emp_POJO find_one(int id)
    {
        for(Emp_POJO e:data) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
