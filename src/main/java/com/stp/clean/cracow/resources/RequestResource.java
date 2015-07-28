package com.stp.clean.cracow.resources;

import com.codahale.metrics.annotation.Timed;
import com.stp.clean.cracow.model.RequestDetails;
import com.stp.clean.cracow.services.RequestService;
import org.eclipse.jetty.server.Response;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/request")
@Produces(MediaType.APPLICATION_JSON)
public class RequestResource {

    private final RequestService requestService;

    public RequestResource(RequestService requestService) {
        this.requestService = requestService;
    }

    @POST
    @Timed
    public int postRequestDetails(@BeanParam RequestDetails requestDetails) {
        requestService.postRequestDetails(requestDetails);
        return Response.SC_OK;
    }

    @GET
    @Timed
    @Path("/list")
    public List<RequestDetails> getRequestDetailsList() {
        return requestService.getRequestDetailsList();
    }
}