package br.com.lm.votapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique=true)
    private String cpf;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    public Associate(String cpf, String name){
        this.cpf = cpf;
        this.name = name;
    }
}
