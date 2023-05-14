package com.sewerrats.sewerratsapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "sewerRatsUser")
public class SewerRatsUser extends AbstractPersistable<Long> {
    @NotNull
    private LocalDateTime created;

    private LocalDateTime updated;
    @NotBlank
    @Column(unique = true)
    private String discordTag;
    @NotBlank
    @Column(unique = true)
    private String discordUsername;
    @NotNull
    //@Column(name="coin")
    private int coin;
    @NotNull
    //@Column(name="profile_picture")
    private String profilePicture;
    @NotNull
    //@Column(name = "experient_points")
    private double experientPoints;

    @OneToMany(mappedBy = "sewerRatsUser")
    List<RatInventory> rats;

    @OneToMany(mappedBy = "opponentOne")
    List<Fight> fights;
    @OneToMany(mappedBy = "opponentTwo")
    List<Fight> fightsAgainst;


    /*
    @ManyToMany
    @JoinTable(
            name = "user_rats",
            joinColumns = @JoinColumn(name = "sewerUser_id"),
            inverseJoinColumns = @JoinColumn(name = "rat_id")
    )
    @Column(nullable = true)
    Set<Rat> rats;


    @ManyToMany
    @JoinTable(
            name = "inventory",
            joinColumns = @JoinColumn(name = "sewerUser_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
            @Column(nullable = true)
    Set<Item> items;

     */


}
