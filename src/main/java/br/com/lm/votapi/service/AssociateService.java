package br.com.lm.votapi.service;

import br.com.lm.votapi.model.Associate;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AssociateService {
    Associate save(Associate associate);
    Optional<Associate> getById(Long id);
    Optional<Associate> getByCpf(String cpf);
}
