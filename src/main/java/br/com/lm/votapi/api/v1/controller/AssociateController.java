package br.com.lm.votapi.api.v1.controller;

import br.com.lm.votapi.api.v1.dto.request.AssociateRequest;
import br.com.lm.votapi.api.v1.dto.response.AssociateResponse;
import br.com.lm.votapi.model.Associate;
import br.com.lm.votapi.service.AssociateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Associate", description = "Associate Controller")
@RequestMapping("/api/v1/associate")
@AllArgsConstructor
@RestController
public class AssociateController {

    private final AssociateService associateService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create associate")
    public ResponseEntity<AssociateResponse> create(@Valid @RequestBody AssociateRequest associateRequest){
        Associate associate = associateService.save(associateRequest.mapToAssociate());
        return ResponseEntity.ok(new AssociateResponse(associate));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get associate by Id")
    public ResponseEntity<AssociateResponse> getById(@PathVariable Long id){
        Optional<Associate> associate = associateService.getById(id);

        if (associate.isPresent()) {
            return ResponseEntity.ok(new AssociateResponse(associate.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
