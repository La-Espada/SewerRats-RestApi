package com.sewerrats.sewerratsapp.service;

import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import com.sewerrats.sewerratsapp.persistence.SewerRatsUserRepository;
import com.sewerrats.sewerratsapp.service.dto.SewerUserDto;
import com.sewerrats.sewerratsapp.service.exceptions.ServiceException;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateSewerUserMutateCommand;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class SewerUserService {

    @Autowired
    private final SewerRatsUserRepository sewerRatsUserRepository;


    public SewerRatsUser createSewerUser(CreateSewerUserMutateCommand createSewerUserMutateCommand){
        SewerRatsUser sewerRatsUser = null;
        try{
            var saved = sewerRatsUserRepository.findByDiscordUsername(createSewerUserMutateCommand.getDiscordUsername());
            if(saved == null){
                sewerRatsUser = SewerRatsUser.builder()
                        .discordTag(createSewerUserMutateCommand.getDiscordTag())
                        .discordUsername(createSewerUserMutateCommand.getDiscordUsername())
                        .coin(0)
                        .experientPoints(0)
                        .created(LocalDateTime.now())
                        .profilePicture(createSewerUserMutateCommand.getProfilePicture())
                        .build();
                log.error("SewerRatsUser with the Discordusername: " + sewerRatsUser.getDiscordUsername() + " already exists!");
                return sewerRatsUserRepository.save(sewerRatsUser);
            }
            return saved;
        }
        catch (PersistenceException e){
            log.error("SewerRatsUser with the Discordusername: " + sewerRatsUser.getDiscordUsername() + " already exists!");
            throw ServiceException.cannotCreateEntity(sewerRatsUser,e);
        }
    }



}
