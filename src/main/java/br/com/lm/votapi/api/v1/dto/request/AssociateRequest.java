package br.com.lm.votapi.api.v1.dto.request;

import br.com.lm.votapi.model.Associate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssociateRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[0-9]*", message="Only numbers is allowed.")
    @Size(min = 11)
    private String cpf;

    public Associate mapToAssociate() {
        return new Associate(cpf, name);
    }
}
