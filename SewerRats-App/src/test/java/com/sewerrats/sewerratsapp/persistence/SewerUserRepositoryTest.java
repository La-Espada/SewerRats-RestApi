package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SewerUserRepositoryTest {

    @Autowired
    SewerRatsUserRepository sewerRatsUserRepository;

    @Test
    void addSewerUsertoDb(){

        SewerRatsUser sewerRatsUser = SewerRatsUser.builder()
                .discordUsername("LA ESPADA")
                .discordTag("#aaaa")
                .coin(10)
                .experientPoints(0)
                .profilePicture("aaaa")
                .build();

        var saved = sewerRatsUserRepository.save(sewerRatsUser);
        var find = sewerRatsUserRepository.findByDiscordUsername("LA ESPADA");

        assertThat(find).isEqualTo(saved);

    }
}
