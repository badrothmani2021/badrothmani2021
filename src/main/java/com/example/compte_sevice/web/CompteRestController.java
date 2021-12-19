package com.example.compte_sevice.web;

import com.example.compte_sevice.entities.Compte;
import com.example.compte_sevice.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class CompteRestController {

    private CompteRepository compteRepository;


    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping (path = "/comptes")
    public List<Compte> listCompte(){
        return compteRepository.findAll();
    }
 
    @GetMapping (path = "/comptes/{id}")
    public Compte getCompte(@PathVariable (name = "id") Long code){
        return compteRepository.findById(code).get();
    }

    @PostMapping(path = "/comptes")
    public Compte save(@RequestBody Compte compte){

         return compteRepository.save(compte);
    }

    @PutMapping (path = "/comptes/{code}")
    public Compte update(@PathVariable Long code,@RequestBody Compte compte){

        return compteRepository.save(compte);
    }

    @DeleteMapping (path = "/comptes/{code}")
    public void delete(@PathVariable Long code){

        compteRepository.deleteById(code);
    }


}
