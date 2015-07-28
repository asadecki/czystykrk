package com.stp.clean.cracow.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class CleanCracowConfiguration extends Configuration {
    @NotEmpty
    private String defaultUserName = "unnamed";

    @JsonProperty
    public String getDefaultUserName() {
        return defaultUserName;
    }

    @JsonProperty
    public void setDefaultUserName(String defaultUserName) {
        this.defaultUserName = defaultUserName;
    }
}