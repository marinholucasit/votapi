package br.com.lm.votapi.api.v1.controller;

import br.com.lm.votapi.api.v1.dto.request.VoteRequest;
import br.com.lm.votapi.api.v1.dto.response.VoteResponse;
import br.com.lm.votapi.service.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Vote", description = "Vote Controller")
@RequestMapping("/api/v1/vote")
@AllArgsConstructor
@RestController
public class VoteController {
    private final VoteService voteService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VoteResponse create(@RequestBody VoteRequest voteRequest) {
        return voteService.save(voteRequest);
    }
}
