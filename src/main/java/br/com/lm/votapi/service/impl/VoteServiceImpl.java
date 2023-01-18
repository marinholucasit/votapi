package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.api.v1.dto.request.VoteRequest;
import br.com.lm.votapi.api.v1.dto.response.VoteResponse;
import br.com.lm.votapi.exception.AssociateNotFoundException;
import br.com.lm.votapi.exception.SessionNotFound;
import br.com.lm.votapi.model.Associate;
import br.com.lm.votapi.model.Session;
import br.com.lm.votapi.model.Vote;
import br.com.lm.votapi.repository.VoteRepository;
import br.com.lm.votapi.service.AssociateService;
import br.com.lm.votapi.service.SessionService;
import br.com.lm.votapi.service.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {

    private final AssociateService associateService;
    private final SessionService sessionService;
    private final VoteRepository voteRepository;

    @Override
    public VoteResponse save(VoteRequest voteRequest) {
        Vote vote = Vote.builder()
                .associate(getAssociateByCpf(voteRequest.getCpf()))
                .session(getSessionById(voteRequest.getVoteSession()))
                .voteValue(voteRequest.getVote())
                .build();

        voteRepository.save(vote);

        return new VoteResponse("Confirmed vote");
    }

    private Associate getAssociateByCpf(String cpf) {
        return associateService.getByCpf(cpf).orElseThrow(() -> new AssociateNotFoundException());
    }

    private Session getSessionById(Long sessionId) {
        return sessionService.getById(sessionId).orElseThrow(() -> new SessionNotFound());
    }


}
