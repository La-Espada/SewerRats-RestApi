package com.sewerrats.sewerratsapp.presentation;

import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import com.sewerrats.sewerratsapp.persistence.SewerRatsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    @Autowired
    SewerRatsUserRepository sewerRatsUserRepository;




    @PostMapping("/")
    public HttpEntity<Void> create(){
        SewerRatsUser sewerRatsUser = SewerRatsUser.builder()
                .discordUsername("La Espada")
                .discordTag("#0000")
                .profilePicture("asdsadsadsadsad")
                .experientPoints(0)
                .coin(10)
                .build();

        sewerRatsUserRepository.save(sewerRatsUser);
        return ResponseEntity.ok().build();
    }
}
