package com.stp.clean.cracow.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.stp.clean.cracow.model.RequestDetails;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/request")
@Produces(MediaType.APPLICATION_JSON)
public class RequestResource {
    private final String defaultUserName;

    public RequestResource(String defaultUserName) {
        this.defaultUserName = defaultUserName;
    }

    @GET
    @Timed
    public RequestDetails sayHello(@QueryParam("userName") Optional<String> userName) {
        return new RequestDetails(userName.or(defaultUserName));
    }
}