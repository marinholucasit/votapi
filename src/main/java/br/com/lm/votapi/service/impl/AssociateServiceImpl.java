package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.model.Associate;
import br.com.lm.votapi.repository.AssociateRepository;
import br.com.lm.votapi.service.AssociateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AssociateServiceImpl implements AssociateService {

    private  final AssociateRepository associateRepository;

    @Override
    public Associate save(Associate associate) {
        return associateRepository.save(associate);
    }

    @Override
    public Optional<Associate> getById(Long id) {
        return associateRepository.findById(id);
    }

    @Override
    public Optional<Associate> getByCpf(String cpf) {
        return associateRepository.findByCpf(cpf);
    }

}
