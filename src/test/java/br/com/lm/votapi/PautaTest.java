package br.com.lm.votapi;

import br.com.lm.votapi.model.Pauta;
import br.com.lm.votapi.repository.PautaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PautaTest {

    @Autowired
    private PautaRepository pautaRepository;

    @Test
    public void mustSavePauta() {
        Pauta pauta = new Pauta("Test pauta");
        this.pautaRepository.save(pauta);
        assertThat(pauta.getId()).isNotNull();
        assertThat(pauta.getDescription()).isEqualTo("Test pauta");
    }

    @Test
    public void mustFoundPauta() {
        Pauta pauta = new Pauta("Test pauta");
        this.pautaRepository.save(pauta);
        assertThat(this.pautaRepository.existsById(pauta.getId())).isTrue();
    }

}
