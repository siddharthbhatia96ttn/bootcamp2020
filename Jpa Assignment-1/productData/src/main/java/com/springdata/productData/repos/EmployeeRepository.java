package com.springdata.productData.repos;

import com.springdata.productData.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    List<Employee> findByName(String Name);
    List<Employee> findByNameStartingWith(String alpha);
    List<Employee> findByAgeBetween(int a,int b);
}
