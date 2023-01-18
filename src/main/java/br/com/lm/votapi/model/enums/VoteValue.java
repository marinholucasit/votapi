package br.com.lm.votapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum VoteValue {
    YES("SIM"),
    NO("NAO");

    @Getter
    private String value;
}
