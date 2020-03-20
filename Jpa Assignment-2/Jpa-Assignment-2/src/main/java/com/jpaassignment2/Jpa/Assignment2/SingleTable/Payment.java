package com.jpaassignment2.Jpa.Assignment2.SingleTable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="pmode",discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {
    @Id
    @Column(name = "id")
    private int id;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}