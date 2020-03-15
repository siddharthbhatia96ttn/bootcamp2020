package com.springdata.productData;

import com.springdata.productData.entities.Employee;
import com.springdata.productData.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class ProductDataApplicationTests {
	@Autowired
    EmployeeRepository  empr;
	@Test
	void contextLoads() {
	}
	@Test
	public void empCreate()
	{
		Employee emp=new Employee();
		emp.setId(1);
		emp.setName("Sidharth");
		emp.setAge(23);
		emp.setLocation("Shahdara");
		empr.save(emp);
	}
	@Test
	public void empUpdate()
	{
		Employee emp=empr.findById(1).get();
		emp.setAge(30);
		empr.save(emp);
	}
/*     @Test
	public void empDelete()
	 {
	 	empr.deleteById(1);
	 }*/
	 @Test
	public void empRead()
	 {
	 	Employee emp=empr.findById(2).get();
		 System.out.println(emp.getName());
	 }
	 @Test
	public void empCount()
	 {
	 	Long a=	empr.count();
		 System.out.println(a);
	 }
	@Test
	public void findallPaging()
	{
		Pageable sortedByAge = PageRequest.of(0, 3, Sort.Direction.ASC,"age");
		Page<Employee> results=empr.findAll(sortedByAge);
		results.forEach(p-> System.out.println(p.getName()+"------------"+p.getAge()));
	}

	 @Test
		public void finderName() {
		List<Employee> employees = empr.findByName("Murli");
		employees.forEach(p -> System.out.println(p.getName() +"...."+p.getAge()));
	}
	@Test
	public void finderEmp()
	{
		List<Employee> employees=empr.findByNameStartingWith("a");
		employees.forEach(p-> System.out.println(p.getName()+"...."+p.getAge()));

	}
	@Test
	public void findAgen()
	{
		List<Employee> employees=empr.findByAgeBetween(20,25);
		employees.forEach(p-> System.out.println((p.getName()+"...."+p.getAge())));
	}

}
