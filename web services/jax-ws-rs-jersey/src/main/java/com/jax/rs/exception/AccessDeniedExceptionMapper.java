package com.jax.rs.exception;

import project.infrastructure.jaxrs.CommonResponse;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.nio.file.AccessDeniedException;

@Provider
public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(AccessDeniedException exception) {
        System.out.println("Access forbidden: " + request.getMethod() + request.getPathInfo());
        return CommonResponse.send(Response.Status.FORBIDDEN, exception.getMessage());
    }
}
