package com.example.demo.q2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class exception_handel extends RuntimeException {
    public exception_handel(String message) {
        super(message);
    }
   /* @Override
    protected ResponseEntity<Object> myexception()*/
}
