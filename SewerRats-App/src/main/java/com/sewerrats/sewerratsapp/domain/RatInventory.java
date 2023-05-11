package com.sewerrats.sewerratsapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rat_inventory")
public class RatInventory extends AbstractPersistable<Long> {

    @ManyToOne()
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_user_rat_inventory"))
    private SewerRatsUser sewerRatsUser;
    @ManyToOne()
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_rat_user_inventory"))
    private Rat rat;

}
