package br.com.lm.votapi.api.v1.controller;

import br.com.lm.votapi.api.v1.dto.request.SessionRequest;
import br.com.lm.votapi.model.Session;
import br.com.lm.votapi.service.SessionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Tag(name = "Voting Session", description = "Session Controller")
@RequestMapping("/api/v1/session")
@AllArgsConstructor
@RestController
public class SessionController {

    private final SessionService sessionService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@Valid @RequestBody SessionRequest session){
        return sessionService.save(session);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getById(@PathVariable Long id){
        return sessionService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session Not found." ));
    }
}
