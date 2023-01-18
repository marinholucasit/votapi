package br.com.lm.votapi.repository;

import br.com.lm.votapi.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
