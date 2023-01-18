package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.api.v1.dto.request.VoteRequest;
import br.com.lm.votapi.api.v1.dto.response.VoteResponse;
import br.com.lm.votapi.model.Associate;
import br.com.lm.votapi.model.Session;
import br.com.lm.votapi.model.Vote;
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

    @Override
    public VoteResponse save(VoteRequest voteRequest) {


        return null;
    }


}
