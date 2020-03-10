package com.example.demo.q2;
import com.example.demo.q2.q2emp;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component
public class q2empdata {
    private static int usercount=3;
    private static List<q2emp> emp=new ArrayList<>();
    static
    {
        emp.add(new q2emp(1,"Siddharth",23));
        emp.add(new q2emp(2,"Mohan",25));
        emp.add(new q2emp(3,"Praveen",26));
    }
    public List<q2emp> findAll()
    {
        return emp;
    }

   public q2emp find_One(int id)
   {
       for(q2emp e :emp) {
           if(e.getId()==id)
           {
               return e;
           }
       }
       return null;
   }

   public q2emp save_emp(q2emp e)
   {
       if(e.getId()==null)
       {
           e.setId(++usercount);
       }
       emp.add(e);
       return e;
   }

   public q2emp deleteById(int id)
   {
       Iterator<q2emp> itr=emp.iterator();
       while(itr.hasNext())
       {
            q2emp emp=itr.next();
            if(emp.getId()==id)
            {
                itr.remove();
                return emp;
            }
       }
       return null;
   }

   public void save(q2emp e,int id)
   {
     for(q2emp x:emp)
     {
         if(x.getId()==id)
         {

         }
     }
   }

}
