package br.com.lm.votapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CpfCanNotVoteException extends RuntimeException {
    public CpfCanNotVoteException() {
        super("This cpf can not vote");
    }
}
