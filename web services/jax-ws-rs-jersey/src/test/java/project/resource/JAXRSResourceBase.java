package project.resource;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JAXRSResourceBase  {

    private int port;
    private final String accessToken = null;

    Response get(String path) { return build(path).get(); }

    Response delete(String path) {
        return build(path).delete();
    }

    Response post(String path, Object entity) {
        return build(path).post(Entity.json(entity));
    }

    Response put(String path, Object entity) {
        return build(path).put(Entity.json(entity));
    }

    Response patch(String path) {
        return build(path).method("PATCH", Entity.text("MUST_BE_PRESENT"));
    }

    Invocation.Builder build(String path) {
        return ClientBuilder.newClient().target("http://localhost:" + port + "/restful" + path)
                .property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true)
                .request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
    }

    static void assertOK(Response response) {
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(), "200/OK");
    }

    static void assertNoContent(Response response) {
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus(), "204/NO_CONTENT");
    }

    static void assertBadRequest(Response response) {
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus(), "400/BAD_REQUEST");
    }

    static void assertForbidden(Response response) {
        assertEquals(Response.Status.FORBIDDEN.getStatusCode(), response.getStatus(), "403/FORBIDDEN");
    }

    static void assertServerError(Response response) {
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus(), "500/INTERNAL_SERVER_ERROR");
    }

    static void assertNotFound(Response response) {
        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus(), "404/NOT_FOUND");
    }
}
