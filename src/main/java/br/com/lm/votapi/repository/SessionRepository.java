package br.com.lm.votapi.repository;

import br.com.lm.votapi.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE s.endDate >= :date and s.pauta.id =:pautaId")
    Optional<Session> getActiveSession(@Param("pautaId") Long pautaId, @Param("date") LocalDateTime date);

}
