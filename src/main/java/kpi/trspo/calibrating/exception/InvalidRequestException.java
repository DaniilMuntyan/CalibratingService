package kpi.trspo.calibrating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class InvalidRequestException extends Exception {

    public InvalidRequestException(String message) {
        super(message);
    }

}
