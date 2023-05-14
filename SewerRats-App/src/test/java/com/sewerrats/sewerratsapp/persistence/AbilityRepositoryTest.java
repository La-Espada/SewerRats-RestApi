package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Ability;
import com.sewerrats.sewerratsapp.domain.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AbilityRepositoryTest {

    @Autowired
    AbilityRepository abilityRepository;

    @Test
    void addAbilityToDatabaseTest(){
        Ability ability = Ability.builder()
                .abilityName("Fireball")
                .abilityDamage(10)
                .abilityPrice(10)
                .abilityType(Type.Dark)
                .abilityPossibility(0.1)
                .build();

        var saved = abilityRepository.save(ability);
        var find = abilityRepository.findByAbilityName("Fireball");


        assertThat(find).isEqualTo(saved);

    }
}
