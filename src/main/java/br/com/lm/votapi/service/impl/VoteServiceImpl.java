package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.api.v1.dto.request.VoteRequest;
import br.com.lm.votapi.api.v1.dto.response.VoteResponse;
import br.com.lm.votapi.exception.AssociateNotFoundException;
import br.com.lm.votapi.exception.DuplicatedVoteException;
import br.com.lm.votapi.exception.SessionInactiveException;
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

import java.util.Optional;

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
                .session(getSessionById(voteRequest.getSession()))
                .voteValue(voteRequest.getVote())
                .build();

        validations(vote, voteRequest);

        voteRepository.save(vote);

        return new VoteResponse("Confirmed vote");
    }

    private void validations(Vote vote, VoteRequest voteRequest) {
        verifyDuplicatedVote(vote);
        verifySessionActive(voteRequest);
    }

    private void verifySessionActive(VoteRequest voteRequest) {
        Session session = sessionService.getById(voteRequest.getSession())
                .orElseThrow(() -> new SessionNotFound());

        if (!session.active())
            throw new SessionInactiveException();
    }

    private void verifyDuplicatedVote(Vote vote) {
        Optional<Vote> voteExits = voteRepository.findByAssociate_idAndSession_Id(
                vote.getAssociate().getId(),
                vote.getSession().getId()
        );

        if (voteExits.isPresent())
            throw new DuplicatedVoteException();
    }

    private Associate getAssociateByCpf(String cpf) {
        return associateService.getByCpf(cpf).orElseThrow(() -> new AssociateNotFoundException());
    }

    private Session getSessionById(Long sessionId) {
        return sessionService.getById(sessionId).orElseThrow(() -> new SessionNotFound());
    }


}
