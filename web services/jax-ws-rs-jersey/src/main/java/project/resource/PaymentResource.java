package project.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import project.application.PaymentApplicationService;
import project.domain.auth.Role;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pay")
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @Inject
    private PaymentApplicationService service;

    @PATCH
    @Path("/{payId}")
    @RolesAllowed(Role.USER)
    public Response updatePaymentState(@PathParam("payId") String payId) {
       return null;
    }

    @GET
    @Path("/modify/{payId}")
    public Response updatePaymentStateAlias(@PathParam("payId") String payId,
                                            @QueryParam("accountId") Integer accountId) {
        return null;
    }
}
