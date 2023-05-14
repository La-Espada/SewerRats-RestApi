package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void addItemToDatabaseTest(){
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

        var saved = itemRepository.save(item);
        var find = itemRepository.findByItemName("Trank");

        assertThat(find).isEqualTo(saved);
    }
}
