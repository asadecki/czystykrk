package com.stp.clean.cracow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class RequestDetails {
    @Length(max = 128)
    private String userName;

    public RequestDetails() {
        // Jackson deserialization
    }

    public RequestDetails(String userName) {
        this.userName = userName;
    }

    @JsonProperty
    public String getUserName() {
        return userName;
    }
}
