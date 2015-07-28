package com.stp.clean.cracow.resources;

import com.codahale.metrics.annotation.Timed;
import com.stp.clean.cracow.model.RequestDetails;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/request")
@Produces(MediaType.APPLICATION_JSON)
public class RequestResource {

    public RequestResource() {
    }

    @GET
    @Timed
    public RequestDetails getRequestDetails(@BeanParam RequestDetails requestDetails) {
        return requestDetails;
    }
}