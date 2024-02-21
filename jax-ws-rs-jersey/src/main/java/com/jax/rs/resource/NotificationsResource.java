package com.jax.rs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Restful API Endpoints 面向用户使用的资源
@Path("/notifications")
public class NotificationsResource {

    @GET
    @Path(("/ping"))
    public String ping() {
        return "response";
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNotification(@PathParam("id") int id) {
        return "notification";
    }
}
