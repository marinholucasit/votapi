package br.com.lm.votapi.service;

import br.com.lm.votapi.api.v1.dto.request.SessionRequest;
import br.com.lm.votapi.model.Session;

import java.util.Optional;

public interface SessionService {
    Session save(SessionRequest sessionRequest);
    Optional<Session> getById(Long id);
}
