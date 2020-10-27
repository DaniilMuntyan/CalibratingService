package kpi.trspo.calibrating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public final class ResourceNotAllowedException extends Exception {

    public ResourceNotAllowedException(String message) {
        super(message);
    }

}
