package br.com.lm.votapi;

import br.com.lm.votapi.model.Associate;
import br.com.lm.votapi.repository.AssociateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class AssociateTest {
    @Autowired
    private AssociateRepository associateRepository;

    @Test
    public void ShouldSaveAssociate() {
        Associate associate = new Associate("04667587640", "Associate Test");
        this.associateRepository.save(associate);
        assertThat(associate.getId()).isNotNull();
        assertThat(associate.getCpf()).isEqualTo("04667587640");
    }

    @Test
    public void ShouldReturnAssociate() {
        Associate associate = new Associate("04667587640", "Associate Test");
        this.associateRepository.save(associate);
        assertThat(this.associateRepository.findByCpf("04667587640")).isNotNull();
    }
}
