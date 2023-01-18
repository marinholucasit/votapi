package br.com.lm.votapi.api.v1.dto.request;

import br.com.lm.votapi.model.enums.VoteValue;
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
public class VoteRequest {
    @NotNull
    @NotEmpty
    @Size(min = 11)
    @Pattern(regexp = "[0-9]*", message="Only numbers allowed")
    private String cpf;

    @NotNull
    @NotEmpty
    private VoteValue vote;

    @NotNull
    private Long voteSession;
}
