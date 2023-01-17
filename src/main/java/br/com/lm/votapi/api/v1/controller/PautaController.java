package br.com.lm.votapi.api.v1.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pauta", description = "Pauta Controller")
@RequestMapping("api/v1/pauta")
@AllArgsConstructor
@RestController
public class PautaController {

    //public ResponseEntity<Pauta> create()

    @GetMapping()
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("true");
    }
}
