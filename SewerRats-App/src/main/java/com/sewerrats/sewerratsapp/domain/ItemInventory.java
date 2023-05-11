package com.sewerrats.sewerratsapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "item_inventory")
public class ItemInventory extends AbstractPersistable <Long>{

    @ManyToOne()
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_user_item_inventory"))
    private SewerRatsUser sewerRatsUser;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_item_user_inventory"))
    private Item item;
}
