package com.sewerrats.sewerratsapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ability")
public class Ability extends AbstractPersistable<Long> {
    //@Column(name = "ability_name")
    @NotBlank
    private String abilityName;
    //@Column(name = "ability_price")
    @NotNull
    private double abilityPrice;
    //@Column(name = "ability_possibility")
    @NotNull
    private double abilityPossibility;
    //@Column(name = "ability_damage")
    @NotNull
    private double abilityDamage;
    //@Column(name = "ability_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type abilityType;
/*
    @ManyToMany(mappedBy = "abilities")
    Set<Rat> rats;

 */

}
