package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.domain.RatInventory;
import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import com.sewerrats.sewerratsapp.domain.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RatInventoryRepositoryTest
{
    @Autowired
    SewerRatsUserRepository sewerRatsUserRepository;
    @Autowired
    RatRepository ratRepository;
    @Autowired
    RatInventoryRepository ratInventoryRepository;

    @Test
    void addRatToSewerUserTest(){
        Rat rat = Rat.builder()
                .ratName("RatOne")
                .ratPrice(1)
                .ratCount(1)
                .ratDamage(10)
                .ratType(Type.Dark)
                .ratSpeed(0.1)
                .ratHealth(11)
                .build();

        SewerRatsUser sewerRatsUser = SewerRatsUser.builder()
                .discordUsername("LA ESPADA")
                .discordTag("#aaaa")
                .coin(10)
                .experientPoints(0)
                .profilePicture("aaaa")
                .build();

        sewerRatsUserRepository.save(sewerRatsUser);
        ratRepository.save(rat);

        RatInventory ratInventory = RatInventory.builder()
                .sewerRatsUser(sewerRatsUser)
                .rat(rat)
                .build();

        var saved = ratInventoryRepository.save(ratInventory);
        var find = ratInventoryRepository.findById(ratInventory.getId()).get();

        assertThat(find).isEqualTo(saved);


    }

}
