package com.springdata.productData.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name= "employee")
public class Employee {
    @Id
    private int id;
    private String name;

    @Column(name = "age")
    private int age;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

}
