package br.com.lm.votapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SessionNotFound extends RuntimeException {
    public SessionNotFound() {
        super("Session not found.");
    }
}
