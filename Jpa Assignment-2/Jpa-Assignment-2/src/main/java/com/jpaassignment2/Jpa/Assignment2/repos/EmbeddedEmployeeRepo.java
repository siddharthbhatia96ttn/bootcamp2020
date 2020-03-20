package com.jpaassignment2.Jpa.Assignment2.repos;

import com.jpaassignment2.Jpa.Assignment2.entities.EmbeddedEmployee;
import org.springframework.data.repository.CrudRepository;

public interface EmbeddedEmployeeRepo extends CrudRepository<EmbeddedEmployee,Integer> {
}