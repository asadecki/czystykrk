package com.stp.clean.cracow.model;

import org.hibernate.validator.constraints.Length;

import javax.ws.rs.QueryParam;

public class Saying {

    @Length(max = 200)
    @QueryParam("saying")
    private String saying;

    public Saying() {
        // Jackson deserialization
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }
}
