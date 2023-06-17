package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Attraction;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.AttractionService;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.ParcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestAttraction {

    @Autowired
    AttractionService attractionService;

    @PostMapping("/attractions") //pour créer une attraction
    public Attraction postAttraction(@RequestBody Attraction attraction){
        return this.attractionService.creerAttraction(attraction.getParc(), attraction.getNomA());
    }

    @GetMapping("/attractions/{id}") //pour dire je veux récupérer une attraction
    public Attraction getAttractionById(@PathVariable("id") Long idAttraction){
        return this.attractionService.recupererAttraction(idAttraction);
    }

    @GetMapping("/attractions") //pour dire je veux récupérer toutes les attractions
    public Iterable<Attraction> getAttractions(){
        return this.attractionService.recupererAttractions();
    }

    @GetMapping("/attractions/ouverte") //pour dire je veux récupérer toutes les attractions ouvertes
    public Iterable<Attraction> getAttractionsOuvertes(){
        return this.attractionService.recupererAttractionsByestOuvert(true);
    }

    @GetMapping("/attractions/ferme") //pour dire je veux récupérer toutes les attractions fermees
    public Iterable<Attraction> getAttractionsFermes(){
        return this.attractionService.recupererAttractionsByestOuvert(false);
    }

    @PostMapping("/attractions/ferme/{id}") //pour fermer une attraction
    public Attraction fermerAttraction(@PathVariable("id") Long idAttraction){
        return this.attractionService.fermerAttraction(idAttraction);
    }

    @PostMapping("/attractions/ouverte/{id}") //pour ouvrir une attraction
    public Attraction ouvrirAttraction(@PathVariable("id") Long idAttraction){
        return this.attractionService.ouvrirAttraction(idAttraction);
    }

    @DeleteMapping("/attractions/{id}") //pour supprimer une attraction
    public void deleteAttraction(@PathVariable("id") Long idAttraction){
        this.attractionService.supAttraction(idAttraction);
    }

}
