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
@Table(name = "rat_abilities")
public class RatAbilities extends AbstractPersistable<Long> {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_rat_item_inventory"))
    private Rat rat;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_item_rat_inventory"))
    private Ability ability;
}
