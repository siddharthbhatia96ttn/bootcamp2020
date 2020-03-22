package com.jpa3.Jpa.Assignment3.repos;

import com.jpa3.Jpa.Assignment3.oneTOmany.entities.Author1toM;
import org.springframework.data.repository.CrudRepository;

public interface Author1tom extends CrudRepository<Author1toM,Integer> {
}
