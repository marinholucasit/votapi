package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.api.v1.dto.request.SessionRequest;
import br.com.lm.votapi.model.Pauta;
import br.com.lm.votapi.model.Session;
import br.com.lm.votapi.repository.SessionRepository;
import br.com.lm.votapi.service.PautaService;
import br.com.lm.votapi.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SessionServiceImpl implements SessionService {

    private final PautaService pautaService;
    private final SessionRepository sessionRepository;

    @Override
    public Session save(SessionRequest sessionRequest) {
        Pauta pauta = getPautaById(sessionRequest.getPautaId());
        int availableMinutes = Optional.ofNullable(sessionRequest.getAvailableMinutes()).orElse(1);
        if (verifyPautaActive(pauta)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "There is an active session for this pauta" + pauta.getId());
        }

        Session newSession = Session.builder()
                .pauta(pauta)
                .availableMinutes(availableMinutes)
                .createdAt(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusMinutes(availableMinutes))
                .build();

        return sessionRepository.save(newSession);
    }

    public Optional<Session> getById(Long id) {
        return sessionRepository.findById(id);
    }

    private Pauta getPautaById(Long id) {
        return pautaService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pauta not found"));
    }

    private boolean verifyPautaActive(Pauta pauta) {
        Optional<Session> sessao = sessionRepository
                .getActiveSession(pauta.getId(), LocalDateTime.now());
        return sessao.isPresent();
    }
}
