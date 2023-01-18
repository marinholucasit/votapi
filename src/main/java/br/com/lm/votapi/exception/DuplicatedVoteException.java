package br.com.lm.votapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicatedVoteException extends RuntimeException {
    public DuplicatedVoteException() {
        super("There is already a vote for this member");
    }
}
