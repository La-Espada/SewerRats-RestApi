package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.domain.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RatRepositoryTest {

    @Autowired
    RatRepository ratRepository;


    @Test
    void addRatToDatabaseTest(){
        Rat rat = Rat.builder()
                .ratName("RatOne")
                .ratPrice(1)
                .ratCount(1)
                .ratDamage(10)
                .ratType(Type.Dark)
                .ratSpeed(0.1)
                .ratHealth(11)
                .ratBase("aaaa")
                .ratEyes("aaaaa")
                .ratHat("aaaaa")
                .build();

        var saved = ratRepository.save(rat);
        var find  = ratRepository.findByRatName("RatOne");

        assertThat(saved).isEqualTo(find);
    }
}
