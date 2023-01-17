package br.com.lm.votapi.api.v1.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionRequest {
    private Long pautaId;

    @Positive(message = "Only positive number allowed")
    private Integer availableMinutes;
}
