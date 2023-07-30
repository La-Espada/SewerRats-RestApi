package com.sewerrats.sewerratsapp.service;

import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.domain.RatInventory;
import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import com.sewerrats.sewerratsapp.domain.Type;
import com.sewerrats.sewerratsapp.persistence.RatInventoryRepository;
import com.sewerrats.sewerratsapp.persistence.RatRepository;
import com.sewerrats.sewerratsapp.persistence.SewerRatsUserRepository;
import com.sewerrats.sewerratsapp.service.dto.SewerUserDto;
import com.sewerrats.sewerratsapp.service.exceptions.ServiceException;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateRatMutateCommand;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateSewerUserMutateCommand;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class SewerUserService {

    @Autowired
    private final SewerRatsUserRepository sewerRatsUserRepository;
    private final RatRepository ratRepository;
    private final RatInventoryRepository ratInventoryRepository;

    public SewerRatsUser createSewerUser(CreateSewerUserMutateCommand createSewerUserMutateCommand){
        SewerRatsUser sewerRatsUser = null;
        try{
            var saved = sewerRatsUserRepository.findByDiscordUsername(createSewerUserMutateCommand.getDiscordUsername());
            if(saved.isEmpty()){
                sewerRatsUser = SewerRatsUser.builder()
                        .discordTag(createSewerUserMutateCommand.getDiscordTag())
                        .discordUsername(createSewerUserMutateCommand.getDiscordUsername())
                        .coin(100)
                        .experientPoints(0)
                        .created(LocalDateTime.now())
                        .profilePicture(createSewerUserMutateCommand.getProfilePicture())
                        .build();
                log.error("SewerRatsUser with the Discordusername: " + sewerRatsUser.getDiscordUsername() + " already exists!");
                return sewerRatsUserRepository.save(sewerRatsUser);
            }
            return saved.get();
        }
        catch (PersistenceException e){
            log.error("SewerRatsUser with the Discordusername: " + sewerRatsUser.getDiscordUsername() + " already exists!");
            throw ServiceException.cannotCreateEntity(sewerRatsUser,e);
        }
    }

    public boolean doesSewerUserExist(String username){
        SewerRatsUser sewerRatsUser = null;
        var user = sewerRatsUserRepository.findByDiscordUsername(username);
        return user.isPresent();
    }

    public List<SewerRatsUser> getSewerRatsUsers(){
        List<SewerRatsUser> sewerRatUserList = null;
        var listOfRats = sewerRatsUserRepository.findAll();
        if(listOfRats.isEmpty()){
            log.error("No User have been found!");
        }
        sewerRatUserList = listOfRats;
        return sewerRatUserList;
    }

    public SewerRatsUser getSewerRatsUserById(Long id){
        SewerRatsUser sewerRatsUser = null;
        var sewerUser = sewerRatsUserRepository.findById(id);
        if(sewerUser.isEmpty()){
            log.error("There is no User with the given ID: " + id);
        }
        sewerRatsUser = sewerUser.get();
        return sewerRatsUser;
    }

    public SewerRatsUser getSewerRatsUserByUsername(String username){
        SewerRatsUser sewerRatsUser = null;
        var sewerUser = sewerRatsUserRepository.findByDiscordUsername(username);

        if(sewerUser.isEmpty()){
            log.error("There is no User with the given Username: " + username);
            return null;
        }
        else {
            sewerRatsUser = sewerUser.get();
            return sewerRatsUser;
        }
    }

    public void deleteSewerUserById(Long id){
        sewerRatsUserRepository.deleteById(id);
        log.info("User with the ID: " + id  + " has been removed!");
    }

    public boolean addRatToUser(String username, CreateRatMutateCommand createRatMutateCommand){
        SewerRatsUser sewerRatsUser = null;
        Rat rat = Rat.builder().ratHat(createRatMutateCommand.getRatHat())
                .ratEyes(createRatMutateCommand.getRatEyes())
                .ratBase(createRatMutateCommand.getRatBase())
                .ratHealth(createRatMutateCommand.getRatHealth())
                .ratSpeed(createRatMutateCommand.getRatSpeed())
                .ratType(Type.valueOf(createRatMutateCommand.getRatType()))
                .ratDamage(createRatMutateCommand.getRatDamage())
                .ratCount(createRatMutateCommand.getRatCount())
                .ratPrice(createRatMutateCommand.getRatPrice())
                .ratName(createRatMutateCommand.getRatName())
                .ratDefense(createRatMutateCommand.getRatDefense())
                .ratPossibility(createRatMutateCommand.getRatPossibility())
                .build();
        ratRepository.save(rat);
        var findSewerUser = sewerRatsUserRepository.findByDiscordUsername(username);
        System.out.println(username);
        if(!findSewerUser.isEmpty()){
            sewerRatsUser = findSewerUser.get();
            int coin = sewerRatsUser.getCoin();
            if((coin - 100) >= 0) {
                sewerRatsUser.setCoin(coin - 100);
                RatInventory ratInventory = new RatInventory(sewerRatsUser, rat);
                ratInventoryRepository.save(ratInventory);
                System.out.println("Rat has been added to the inventory!");
                return true;
            }
            else{
                log.error("Not enough coins");
                return false;
            }


        }
        return false;
    }
}




