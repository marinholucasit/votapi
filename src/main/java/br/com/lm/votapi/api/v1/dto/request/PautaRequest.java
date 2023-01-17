package br.com.lm.votapi.api.v1.dto.request;

import br.com.lm.votapi.model.Pauta;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PautaRequest {
    @NotNull
    @NotEmpty
    private String description;

    public Pauta mapToPauta() {
        return new Pauta(description);
    }
}
