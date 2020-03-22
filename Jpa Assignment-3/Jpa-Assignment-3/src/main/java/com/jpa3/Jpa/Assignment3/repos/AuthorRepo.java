package com.jpa3.Jpa.Assignment3.repos;

import com.jpa3.Jpa.Assignment3.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Integer> {
}
