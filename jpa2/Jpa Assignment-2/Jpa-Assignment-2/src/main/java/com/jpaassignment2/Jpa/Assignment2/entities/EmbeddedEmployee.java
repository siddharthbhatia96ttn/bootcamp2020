package com.jpaassignment2.Jpa.Assignment2.entities;

import javax.persistence.*;

@Entity
@Table(name="embeddedemployee")
public class EmbeddedEmployee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  int empid;
    private String empfirstname;
    private String emplastname;
    private int empage;
    @Embedded
    Salary sal;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpfirstname() {
        return empfirstname;
    }

    public void setEmpfirstname(String empfirstname) {
        this.empfirstname = empfirstname;
    }

    public String getEmplastname() {
        return emplastname;
    }

    public void setEmplastname(String emplastname) {
        this.emplastname = emplastname;
    }

    public int getEmpage() {
        return empage;
    }

    public void setEmpage(int empage) {
        this.empage = empage;
    }

    public Salary getSal() {
        return sal;
    }

    public void setSal(Salary sal) {
        this.sal = sal;
    }
}
