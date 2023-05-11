
package com.sewerrats.sewerratsapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "fight")
public class Fight extends AbstractPersistable<Long> {
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_Fight_SewerUser_One"))
    private SewerRatsUser opponentOne;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_Fight_SewerUser_Two"))
    private SewerRatsUser opponentTwo;
    //@Column(name = "draw")
    @NotNull
    private boolean draw;
    //@Column(name = "winner")
    @NotBlank
    private String winner;
    //@Column(name = "loser")
    @NotBlank
    private String loser;
    //@Column(name = "battle_started_at")
    @NotNull
    private LocalDateTime battleStartedAt;
    //@Column(name = "battle_ended_at")
    @NotNull
    private LocalDateTime battleEndedAt;

}


