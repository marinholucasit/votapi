package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.model.Pauta;
import br.com.lm.votapi.repository.PautaRepository;
import br.com.lm.votapi.service.PautaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PautaServiceImpl implements PautaService {
    private final PautaRepository pautaRepository;

    @Override
    public Pauta save(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @Override
    public Optional<Pauta> getById(Long id) {
        return pautaRepository.findById(id);
    }
}
