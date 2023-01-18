package br.com.lm.votapi.repository;

import br.com.lm.votapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByAssociate_idAndSession_Id(Long associateId, long sessionId);
}
