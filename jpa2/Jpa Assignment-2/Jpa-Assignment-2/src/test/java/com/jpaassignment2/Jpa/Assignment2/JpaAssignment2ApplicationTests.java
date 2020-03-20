package com.jpaassignment2.Jpa.Assignment2;

import com.jpaassignment2.Jpa.Assignment2.Joined.Cheque2;
import com.jpaassignment2.Jpa.Assignment2.Joined.CreditCard2;
import com.jpaassignment2.Jpa.Assignment2.SingleTable.Cheque;
import com.jpaassignment2.Jpa.Assignment2.SingleTable.CreditCard;
import com.jpaassignment2.Jpa.Assignment2.entities.EmbeddedEmployee;
import com.jpaassignment2.Jpa.Assignment2.entities.Employee;
import com.jpaassignment2.Jpa.Assignment2.entities.Salary;
import com.jpaassignment2.Jpa.Assignment2.repos.*;
import com.jpaassignment2.Jpa.Assignment2.tableperclass.bankcheck3;
import com.jpaassignment2.Jpa.Assignment2.tableperclass.card3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Embedded;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpaAssignment2ApplicationTests {

	@Autowired
	EmployeeRepo repository;

	@Autowired
	PaymentRepository repository2;

	@Autowired
	PaymentRepository2 repository3;

	@Autowired
	PaymentRepository3 repository4;

	@Autowired
	EmbeddedEmployeeRepo repository5;

	@Test
	void contextLoads() {
	}
	@Test
	public void testInsertion()
	{
		Employee emp=new Employee();
		emp.setFirstName("Raghav");
		emp.setLastName("Gupta");
		emp.setSalary(34100);
		emp.setAge(50);
		repository.save(emp);
	}

	@Test
	public void testListemp()
	{
		List<Object[]>emp=repository.findSalary();
		for(Object[]i:emp)
		{
			System.out.print(i[0]+" ");
			System.out.println(i[1]);
		}
	}

	@Test
	public void testAvgsalary()
	{
		System.out.println(repository.avgsalary());
	}

	@Transactional

	@Test
	public void testUpdateEmployeeSalary(){
		repository.updateSalary(30000,repository.avgsalary());
	}

	@Transactional

	@Test
	public void testDeleteMinSal()
	{
		repository.deleteSalary(repository.minSalary());
	}

	@Test
	public void testEmpDetails()
	{
		List<Object[]> emp=repository.findEmpDetails();
		for(Object[] obj : emp)
		{
			System.out.print(obj[0]+" ");
			System.out.print(obj[1]+" ");
			System.out.println(obj[2]);
		}
	}

	@Transactional

	@Test
	public void testDeleteEmployee()
	{
		repository.delByEmpAge(45);
	}

	//Single Table
	@Test
	public void testCreditCard()
	{
		CreditCard cc=new CreditCard();
		cc.setId(1);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository2.save(cc);
	}


	//Table Per Class
	@Test
	public void testCreditCard2()
	{
		CreditCard2 cc=new CreditCard2();
		cc.setId(1);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository3.save(cc);
	}
	@Test
	public void testCheque2()
	{
		Cheque2 cc=new Cheque2();
		cc.setId(1);
		cc.setAmount(2000);
		cc.setChequeno("2234567890");
		repository3.save(cc);
	}

	//Joined
	@Test
	public void testCreditCard3()
	{
		card3 cc=new card3();
		cc.setId(1);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository4.save(cc);
	}
	@Test
	public void testCheque3()
	{
		bankcheck3 cc=new bankcheck3();
		cc.setId(3);
		cc.setAmount(2000);
		cc.setChecknumber("2234567890");
		repository4.save(cc);
	}

	@Test
	public void testEmployeeRepo()
	{
		EmbeddedEmployee emb=new EmbeddedEmployee();
		emb.setEmpfirstname("Siddharth");
		emb.setEmplastname("Bhatia");
		emb.setEmpage(23);
		Salary sal=new Salary();
		sal.setBasicsalary(23000);
		sal.setBonussalary(15000);
		sal.setSpecialallowance(8000);
		sal.setTaxamount(4000);
		emb.setSal(sal);
		repository5.save(emb);
	}
}

