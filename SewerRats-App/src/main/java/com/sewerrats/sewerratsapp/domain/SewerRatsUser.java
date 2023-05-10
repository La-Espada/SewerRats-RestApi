package com.sewerrats.sewerratsapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "sewerRatsUser")
public class SewerRatsUser extends AbstractPersistable<Long> {
    @NotBlank
    @Column(name = "discord_tag", unique = true)
    private String discordTag;
    @NotBlank
    @Column(name = "discord_username", unique = true)
    private String discordUsername;
    @NotEmpty
    @Column(name="coin")
    private int coin;
    @NotNull
    @Column(name="profile_picture")
    private String profilePicture;
    @NotEmpty
    @Column(name = "experient_points")
    private double experientPoints;

    @ManyToMany
    @JoinTable(
            name = "user_rats",
            joinColumns = @JoinColumn(name = "sewerUser_id"),
            inverseJoinColumns = @JoinColumn(name = "rat_id")
    )
    Set<Rat> rats;


    @ManyToMany
    @JoinTable(
            name = "inventory",
            joinColumns = @JoinColumn(name = "sewerUser_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    Set<Item> items;


}
