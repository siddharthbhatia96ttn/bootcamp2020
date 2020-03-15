package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("Some bean filter")
public class Emp_Pojo_Dynamic {
    Integer rollno1;
    String username1;
    Integer age1;
    String password1;

    public Emp_Pojo_Dynamic(Integer rollno1, String username1, Integer age1, String password1) {
        this.rollno1 = rollno1;
        this.username1 = username1;
        this.age1 = age1;
        this.password1 = password1;
    }

    public Integer getRollno1() {
        return rollno1;
    }

    public void setRollno1(Integer rollno1) {
        this.rollno1 = rollno1;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public Integer getAge1() {
        return age1;
    }

    public void setAge1(Integer age1) {
        this.age1 = age1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    @Override
    public String toString() {
        return "Emp_Pojo_Dynamic{" +
                "rollno1=" + rollno1 +
                ", username1='" + username1 + '\'' +
                ", age1=" + age1 +
                ", password1='" + password1 + '\'' +
                '}';
    }
}
