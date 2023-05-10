package com.sewerrats.sewerratsapp.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table()
public class Rat extends AbstractPersistable<Long> {
    @Column(name = "rat_name")
    @NotBlank
    private String ratName;
    @Column(name = "rat_type")
    @NotNull
    private Type ratType;
    @Column(name = "rat_price")
    @NotNull
    private double ratPrice;
    @Column(name = "rat_possibility")
    @NotNull
    private double ratPossibility;
    @Column(name = "rat_health")
    @NotNull
    private double ratHealth;
    @Column(name = "rat_speed")
    @NotNull
    private double ratSpeed;
    @Column(name = "rat_defense")
    @NotNull
    private double ratDefense;
    @Column(name = "rat_damage")
    @NotNull
    private double ratDamage;
    @Column(name = "rat_count")
    @NotNull
    private int ratCount;
}
