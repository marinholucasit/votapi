package br.com.lm.votapi.model;

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
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    @NotNull
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime endDate;

    private LocalDateTime sendDate;

    private Integer availableMinutes;

    public Boolean active() {
        return  endDate.isAfter(LocalDateTime.now());
    }
}
