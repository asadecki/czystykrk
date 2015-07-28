package com.stp.clean.cracow.resources;

import com.codahale.metrics.annotation.Timed;
import com.stp.clean.cracow.model.Saying;
import com.stp.clean.cracow.services.SayingService;
import org.eclipse.jetty.server.Response;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/saying")
@Produces(MediaType.APPLICATION_JSON)
public class SayingResource {
    private final SayingService sayingService;

    public SayingResource(SayingService sayingService) {
        this.sayingService = sayingService;
    }

    @POST
    @Timed
    public int postRequestDetails(@BeanParam Saying saying) {
        sayingService.postSaying(saying);
        return Response.SC_OK;
    }

    @GET
    @Timed
    public String getRequestDetailsList() {
        return sayingService.getSaying();
    }
}
