package project.infrastructure.jaxrs;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        System.out.println("Validation Failed :" + exception.getMessage());
        String msg = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("；"));
        return CommonResponse.send(Response.Status.BAD_REQUEST, msg);
    }
}
