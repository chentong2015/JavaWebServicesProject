package project.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import project.application.ProductApplicationService;
import project.domain.auth.Role;
import project.domain.product.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductApplicationService service;

    @GET
    public Iterable<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") Integer id) {
        return null;
    }

    @PUT
    @RolesAllowed(Role.ADMIN)
    public Response updateProduct(@Valid Product product) {
        return null;
    }

    @POST
    @RolesAllowed(Role.ADMIN)
    public Product createProduct(@Valid Product product) {
        return null;
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed(Role.ADMIN)
    public Response removeProduct(@PathParam("id") Integer id) {
        return null;
    }
}
