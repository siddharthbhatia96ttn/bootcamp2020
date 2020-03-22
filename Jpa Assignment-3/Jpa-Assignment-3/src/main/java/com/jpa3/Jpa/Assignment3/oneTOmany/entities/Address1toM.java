package com.jpa3.Jpa.Assignment3.oneTOmany.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address1toM {
    private int streetnumber;
    private String location;
    private String state;

    public int getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(int streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
