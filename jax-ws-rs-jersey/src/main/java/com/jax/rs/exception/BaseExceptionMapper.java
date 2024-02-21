package com.jax.rs.exception;

import project.infrastructure.jaxrs.CommonResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BaseExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        System.out.println(exception.getMessage());
        return CommonResponse.failure(exception.getMessage());
    }
}
