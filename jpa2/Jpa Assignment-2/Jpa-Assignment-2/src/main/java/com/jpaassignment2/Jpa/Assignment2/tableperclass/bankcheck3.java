package com.jpaassignment2.Jpa.Assignment2.tableperclass;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="bankcheck3")
@PrimaryKeyJoinColumn(name="id")
public class bankcheck3 extends Payment3 {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
