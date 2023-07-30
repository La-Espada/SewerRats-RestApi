package com.sewerrats.sewerratsapp.service;

import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.domain.Type;
import com.sewerrats.sewerratsapp.persistence.RatRepository;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateRatMutateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class RatService {


    @Autowired
    private final RatRepository ratRepository;

    public Rat createRat(CreateRatMutateCommand createRatMutateCommand){
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

        return ratRepository.save(rat);
    }

    public List<Rat> getRats(){
        List<Rat> rats = ratRepository.findAll();
        if(rats.isEmpty()){
            log.error("There are no Rats yet!");
        }
        return rats;
    }

    public void deleteRatById(Long id){
        var saved = ratRepository.findById(id);
        if(saved.isEmpty()){
            log.error("Rat with the ID: " + id + " can not be found!");
        }
        else{
            ratRepository.deleteById(id);
        }
    }

}
