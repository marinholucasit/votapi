package br.com.lm.votapi.api.v1.dto.response;

import br.com.lm.votapi.model.Associate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class AssociateResponse {
    private Long id;
    private String name;
    private String cpf;

    public AssociateResponse(Associate associate) {
        this.id = associate.getId();
        this.cpf = associate.getCpf();
        this.name = associate.getName();
    }
}
