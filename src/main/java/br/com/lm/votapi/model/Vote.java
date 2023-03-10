package br.com.lm.votapi.model;

import br.com.lm.votapi.model.enums.VoteValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "associate_id")
    private Associate associate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private VoteValue voteValue;

    @NotNull
    @Builder.Default
    private LocalDateTime voteDate = LocalDateTime.now();

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "session_id")
    private Session session;
}
