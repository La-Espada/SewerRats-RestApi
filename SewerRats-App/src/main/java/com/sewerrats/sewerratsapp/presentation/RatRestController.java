package com.sewerrats.sewerratsapp.presentation;

import com.sewerrats.sewerratsapp.domain.Rat;
import com.sewerrats.sewerratsapp.service.RatService;
import com.sewerrats.sewerratsapp.service.mutatecommand.CreateRatMutateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rat")
public class RatRestController {

    private final RatService ratService;

    @GetMapping("/")
    private HttpEntity<List<Rat>> getRats(){
        List<Rat> rat = ratService.getRats();

        return (rat.isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(rat.stream().toList());
    }


    @PostMapping("/")
    private HttpEntity<Rat> createRat(@RequestBody CreateRatMutateCommand createRatMutateCommand){
        Rat rat = ratService.createRat(createRatMutateCommand);
        return ResponseEntity.ok(rat);
    }

    @DeleteMapping("/{id}")
    private HttpEntity<Void> deleteRatById(@PathVariable("id") Long id){
        ratService.deleteRatById(id);
        return ResponseEntity.ok().build();
    }
}
