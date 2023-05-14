package com.sewerrats.sewerratsapp.service.dto;

import com.sewerrats.sewerratsapp.domain.SewerRatsUser;

public record SewerUserDto(Long id, String discordTag, String discordUsername, int coin, String profilePicture, double experientPoints) {
    public SewerUserDto(SewerRatsUser sewerRatsUser){
        this(sewerRatsUser.getId(),sewerRatsUser.getDiscordTag(),sewerRatsUser.getDiscordUsername(),sewerRatsUser.getCoin(),
                sewerRatsUser.getProfilePicture(),sewerRatsUser.getExperientPoints());
    }
}
