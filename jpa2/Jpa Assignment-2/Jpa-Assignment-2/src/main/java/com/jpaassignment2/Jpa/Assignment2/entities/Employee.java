package com.jpaassignment2.Jpa.Assignment2.entities;

import javax.persistence.*;

@Entity
@Table(name="employeetable")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="empid")
    int id;
    @Column(name="empfirstname")
    String firstName;
    @Column(name="emplastname")
    String lastName;
    @Column(name="empsalary")
    int salary;
    @Column(name="empage")
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
