package br.com.lm.votapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SessionInactiveException extends RuntimeException {
    public SessionInactiveException() {
        super("Session inactive");
    }
}
