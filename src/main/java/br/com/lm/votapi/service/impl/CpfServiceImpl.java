package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.api.v1.dto.response.CpfResponse;
import br.com.lm.votapi.client.UserInfoCpf;
import br.com.lm.votapi.service.CpfService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class CpfServiceImpl implements CpfService {

    private final UserInfoCpf userInfoCpf;
    private static final String ABLE_TO_VOTE = "ABLE_TO_VOTE";

    @Override
    public boolean cpfAllowedVote(String cpf) {
        try {
            CpfResponse cpfResponse = userInfoCpf.getStatusCpf(cpf);
            return (cpfResponse.getStatus().toUpperCase().equals(ABLE_TO_VOTE))? true: false;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid cpf");
        }

    }
}
