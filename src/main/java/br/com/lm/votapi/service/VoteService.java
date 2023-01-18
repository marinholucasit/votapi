package br.com.lm.votapi.service;

import br.com.lm.votapi.api.v1.dto.request.VoteRequest;
import br.com.lm.votapi.api.v1.dto.response.VoteResponse;

public interface VoteService {
    VoteResponse save(VoteRequest voteRequest);
}
