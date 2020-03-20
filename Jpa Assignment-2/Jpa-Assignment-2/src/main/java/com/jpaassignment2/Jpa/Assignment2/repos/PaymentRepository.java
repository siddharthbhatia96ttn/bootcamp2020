package com.jpaassignment2.Jpa.Assignment2.repos;

import com.jpaassignment2.Jpa.Assignment2.SingleTable.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {

}