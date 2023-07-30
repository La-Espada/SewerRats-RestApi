package com.sewerrats.sewerratsapp.presentation;

import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import com.sewerrats.sewerratsapp.domain.Type;
import com.sewerrats.sewerratsapp.persistence.RatRepository;
import com.sewerrats.sewerratsapp.service.SewerUserService;
import com.sewerrats.sewerratsapp.service.mutatecommand.AddRatToSewerUserMutateCommand;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateRatMutateCommand;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateSewerUserMutateCommand;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sewerRatsUser")
public class SewerRatsUserRestController {

    private final SewerUserService sewerUserService;

    @GetMapping("/")
    public HttpEntity<List<SewerRatsUser>> getSewerRatsUser(){
        List<SewerRatsUser> sewerRatsUsers =sewerUserService.getSewerRatsUsers();

        return (sewerRatsUsers.isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(sewerRatsUsers.stream().toList());
    }

    @GetMapping({"/exist/{username}"})
    public HttpEntity<Boolean> doesSewerUserExist(@PathVariable String username){
        boolean exist = sewerUserService.doesSewerUserExist(username);
        if(exist){
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/")
    public HttpEntity<String> createSewerRatsUser(@RequestBody CreateSewerUserMutateCommand createSewerUserMutateCommand){
        SewerRatsUser sewerRatsUserExist = sewerUserService.getSewerRatsUserByUsername(createSewerUserMutateCommand.getDiscordUsername());
        if(sewerRatsUserExist != null){
            return ResponseEntity.status(409).body("User with this username already exists!");
        }
        SewerRatsUser sewerRatsUser = sewerUserService.createSewerUser(createSewerUserMutateCommand);
        return ResponseEntity.ok("user has been created!");
    }


    @PostMapping({"/addRat/{username}"})
    public HttpEntity<String> addRattoSewerUser(@PathVariable String username, @RequestBody CreateRatMutateCommand createRatMutateCommand){
        boolean allow = sewerUserService.addRatToUser(username,createRatMutateCommand);
        if(allow){
            return ResponseEntity.ok("Rat has been added!");
        }
        else{
            return ResponseEntity.status(500).body("You do not have enough coins!");
        }
    }

}
