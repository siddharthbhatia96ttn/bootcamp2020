package com.jpaassignment2.Jpa.Assignment2.Joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="bankcheck")
public class Cheque2 extends Payment2 {
    @Column(name="checknumber")
    private String chequenumber;

    public String getChequeno() {
        return chequenumber;
    }

    public void setChequeno(String chequenumber) {
        this.chequenumber = chequenumber;
    }
}