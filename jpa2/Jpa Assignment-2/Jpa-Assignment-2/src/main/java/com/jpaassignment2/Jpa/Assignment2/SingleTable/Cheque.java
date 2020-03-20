package com.jpaassignment2.Jpa.Assignment2.SingleTable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ck")
@Table(name="payment")
public class Cheque extends Payment{
    private String chequeno;

    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }
}