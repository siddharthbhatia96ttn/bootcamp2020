package com.jpaassignment2.Jpa.Assignment2.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Salary {
    private int basicsalary;
    private int bonussalary;
    private int taxamount;
    private int specialallowance;

    public int getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(int basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getBonussalary() {
        return bonussalary;
    }

    public void setBonussalary(int bonussalary) {
        this.bonussalary = bonussalary;
    }

    public int getTaxamount() {
        return taxamount;
    }

    public void setTaxamount(int taxamount) {
        this.taxamount = taxamount;
    }

    public int getSpecialallowance() {
        return specialallowance;
    }

    public void setSpecialallowance(int specialallowance) {
        this.specialallowance = specialallowance;
    }
}
