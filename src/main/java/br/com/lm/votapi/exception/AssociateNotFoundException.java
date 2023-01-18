package br.com.lm.votapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssociateNotFoundException extends RuntimeException {
    public AssociateNotFoundException() {
        super("Associate not found");
    }
}
