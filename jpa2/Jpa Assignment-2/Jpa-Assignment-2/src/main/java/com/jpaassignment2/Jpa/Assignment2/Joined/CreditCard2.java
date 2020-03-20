package com.jpaassignment2.Jpa.Assignment2.Joined;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="card")
public class CreditCard2 extends Payment2{
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}