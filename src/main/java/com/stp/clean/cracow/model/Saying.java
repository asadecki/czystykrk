package com.stp.clean.cracow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.ws.rs.QueryParam;

public class Saying {

    @Length(max = 200)
    @QueryParam("saying")
    private String saying;

    public Saying() {
        // Jackson deserialization
    }

    @JsonProperty
    public String getSaying() {
        return saying;
    }

    @JsonProperty
    public void setSaying(String saying) {
        this.saying = saying;
    }
}
