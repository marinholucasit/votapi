package br.com.lm.votapi.repository;

import br.com.lm.votapi.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssociateRepository extends JpaRepository<Associate, Long> {
    Optional<Associate> findByCpf(String cpf);
}
