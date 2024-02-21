package project.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import project.application.AccountApplicationService;
import project.domain.account.Account;
import project.domain.account.validation.UniqueAccount;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    private AccountApplicationService service;

    @GET
    @Path("/{username}")
    public Account getUser(@PathParam("username") String username) {
        return null;
    }

    @POST
    public Response createUser(@Valid @UniqueAccount Account user) {
        return null;
    }

    @PUT
    public Response updateUser(@Valid Account user) {
        return null;
    }
}
