package br.com.lm.votapi.repository;

import br.com.lm.votapi.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
