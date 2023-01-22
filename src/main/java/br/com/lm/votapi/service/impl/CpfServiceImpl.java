package br.com.lm.votapi.service.impl;

import br.com.lm.votapi.api.v1.dto.response.CpfResponse;
import br.com.lm.votapi.client.UserInfoCpf;
import br.com.lm.votapi.service.CpfService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
@Log4j2
public class CpfServiceImpl implements CpfService {

    private final UserInfoCpf userInfoCpf;
    private static final String ABLE_TO_VOTE = "ABLE_TO_VOTE";

    @Override
    public boolean cpfAllowedVote(String cpf) {
        try {
            log.info("Verify in external service if CPF {} can vote", cpf);
            CpfResponse cpfResponse = userInfoCpf.getStatusCpf(cpf);
            log.info("response: {}", cpfResponse.getStatus());
            return (cpfResponse.getStatus().toUpperCase().equals(ABLE_TO_VOTE))? false: true;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid cpf");
        }

    }
}
