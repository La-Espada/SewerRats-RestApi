package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Ability;
import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.domain.RatAbilities;
import com.sewerrats.sewerratsapp.domain.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RatAbilitiesRepositoryTest
{
    @Autowired
    RatRepository ratRepository;
    @Autowired
    AbilityRepository abilityRepository;
    @Autowired
    RatAbilitiesRepository ratAbilitiesRepository;

    @Test
    void addAbilitiesToRatTest(){
        Rat rat = Rat.builder()
                .ratName("RatOne")
                .ratPrice(1)
                .ratCount(1)
                .ratDamage(10)
                .ratType(Type.Dark)
                .ratSpeed(0.1)
                .ratHealth(11)
                .build();

        Ability ability = Ability.builder()
                .abilityName("Fireball")
                .abilityDamage(10)
                .abilityPrice(10)
                .abilityType(Type.Dark)
                .abilityPossibility(0.1)
                .build();

        ratRepository.save(rat);
        abilityRepository.save(ability);

        RatAbilities abilities = RatAbilities.builder()
                .rat(rat)
                .ability(ability)
                .build();

        var saved = ratAbilitiesRepository.save(abilities);
        var find = ratAbilitiesRepository.findById(abilities.getId()).get();

        assertThat(find).isEqualTo(saved);

    }
}
