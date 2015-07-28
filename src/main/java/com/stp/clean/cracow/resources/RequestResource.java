package com.stp.clean.cracow.resources;

import com.codahale.metrics.annotation.Timed;
import com.stp.clean.cracow.dao.MongoDao;
import com.stp.clean.cracow.model.RequestDetails;
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

    private final MongoDao mongoDao;

    public RequestResource(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

    @POST
    @Timed
    public int postRequestDetails(@BeanParam RequestDetails requestDetails) {
        mongoDao.addNewRequestDetails(requestDetails);
        return Response.SC_OK;
    }

    @GET
    @Timed
    @Path("/list")
    public List<RequestDetails> getRequestDetailsList() {
        return mongoDao.getAllRequestDetailsList();
    }
}