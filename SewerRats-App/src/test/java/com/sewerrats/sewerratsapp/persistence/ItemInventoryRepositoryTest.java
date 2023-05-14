package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Item;
import com.sewerrats.sewerratsapp.domain.ItemInventory;
import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemInventoryRepositoryTest {


    @Autowired
    SewerRatsUserRepository sewerRatsUserRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemInventoryRepository itemInvetoryRepository;

    @Test
    void addItemToUserTest(){
        SewerRatsUser sewerRatsUser = SewerRatsUser.builder()
                .discordUsername("LA ESPADA")
                .discordTag("#aaaa")
                .coin(10)
                .experientPoints(0)
                .profilePicture("aaaa")
                .build();

        Item item = Item.builder()
                .itemName("Trank")
                .itemCount(1)
                .itemDescription("asdsadsadsadsadsa")
                .itemHeal(10)
                .itemParalyze(0)
                .itemPicture("asdsadsadsadsa")
                .itemPoison(0)
                .itemSleep(0)
                .build();

        ItemInventory itemInventory = ItemInventory.builder()
                .item(item)
                .sewerRatsUser(sewerRatsUser)
                .build();

        sewerRatsUserRepository.save(sewerRatsUser);

        itemRepository.save(item);

        var saved = itemInvetoryRepository.save(itemInventory);
        var find = itemInvetoryRepository.findById(itemInventory.getId()).get();

        assertThat(find).isEqualTo(saved);

    }
}
