package br.com.lm.votapi.api.v1.controller;

import br.com.lm.votapi.api.v1.dto.request.PautaRequest;
import br.com.lm.votapi.model.Pauta;
import br.com.lm.votapi.service.PautaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Pauta", description = "Pauta Controller")
@RequestMapping("api/v1/pauta")
@AllArgsConstructor
@RestController
public class PautaController {

    private final PautaService pautaService;

    @Operation(summary = "Create a pauta")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pauta> create(@Valid @RequestBody PautaRequest pautaRequest) {
        Pauta pauta = pautaService.save(pautaRequest.mapToPauta());
        return ResponseEntity.ok(pauta);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get pauta by Id")
    public ResponseEntity<Pauta> getById(@PathVariable Long id){
        Optional<Pauta> pauta = pautaService.getById(id);

        if (pauta.isPresent())
            return ResponseEntity.ok(pauta.get());

        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("true");
    }
}
