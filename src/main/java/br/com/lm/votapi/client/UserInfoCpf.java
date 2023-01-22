package br.com.lm.votapi.client;

import br.com.lm.votapi.api.v1.dto.response.CpfResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://user-info.herokuapp.com/users/", value = "GetCpf" )
public interface UserInfoCpf {
    @GetMapping("/{cpf}")
    CpfResponse getStatusCpf(@PathVariable("cpf") String cpf);

}
