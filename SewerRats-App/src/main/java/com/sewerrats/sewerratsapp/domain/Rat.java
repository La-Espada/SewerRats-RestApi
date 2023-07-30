package com.sewerrats.sewerratsapp.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "rat")
public class Rat extends AbstractPersistable<Long> {
    //@Column(name = "rat_name")
    @NotBlank
    private String ratName;
    //@Column(name = "rat_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type ratType;
    //@Column(name = "rat_price")
    @NotNull
    private double ratPrice;
    //@Column(name = "rat_possibility")
    @NotNull
    private double ratPossibility;
    //@Column(name = "rat_health")
    @NotNull
    private double ratHealth;
    //@Column(name = "rat_speed")
    @NotNull
    private double ratSpeed;
    //@Column(name = "rat_defense")
    @NotNull
    private double ratDefense;
    //@Column(name = "rat_damage")
    @NotNull
    private double ratDamage;
    //@Column(name = "rat_count")
    @NotNull
    private int ratCount;

    @NotBlank
    private String ratHat;

    @NotBlank
    private String ratBase;

    @NotBlank
    private String ratEyes;

    @OneToMany(mappedBy = "rat")
    List<RatInventory> users;

    /*
    @ManyToMany(mappedBy = "rats")
    Set<SewerRatsUser> sewerRatsUsers;

    @ManyToMany
    @JoinTable(
            name = "rat_abilities",
            joinColumns = @JoinColumn(name = "rat_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")

    )
    Set<Ability> abilities= new HashSet<>(4);
     */
}
