package br.com.lm.votapi.service;

import br.com.lm.votapi.model.Pauta;

import java.util.Optional;

public interface PautaService {
    Pauta save(Pauta pauta);
    Optional<Pauta> getById(Long id);
}
