package com.jpaassignment2.Jpa.Assignment2.repos;

import com.jpaassignment2.Jpa.Assignment2.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    //JPQL
    @Query("Select firstName,lastName from Employee where salary>(Select avg(salary) from Employee) order by age asc, salary desc")
    List<Object[]> findSalary();

    @Query("Select avg(salary) from Employee")
    public int avgsalary();

    @Modifying
    @Query("Update Employee set salary=:newsal where salary <:avgsal")
    public void updateSalary(@Param("newsal")int newsal, @Param("avgsal")int avgsal);

    @Query("Select min(salary) from Employee")
    public int minSalary();

    @Modifying
    @Query("Delete from Employee where salary=:minsal")
    public void deleteSalary(@Param("minsal")int minsal);

    //Native Sql Salary
    @Query(value = "Select empid,empfirstname,empage from employeetable where emplastname='singh'",nativeQuery = true)
    List<Object[]> findEmpDetails();

    @Modifying
    @Transactional
    @Query(value = "Delete from employeetable where empage>:age", nativeQuery = true)
    void delByEmpAge(@Param("age") int age);
}
