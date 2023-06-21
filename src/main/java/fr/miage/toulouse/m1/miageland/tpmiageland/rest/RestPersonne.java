package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.export.PersonneImport;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestPersonne {

    @Autowired
    PersonneService personneService;

//    @PostMapping("/personnes")
//    public Personne postPersonne(@RequestBody PersonneImport personneImport)
//    {
//        return this.personneService.creerPersonne(personneImport.getNom(),
//                personneImport.getPrenom(), personneImport.getAdresseMail(),
//                personneImport.getNomRole());
//    }

//    @GetMapping("/personnes")
//    public Personne getPersonne() {
//        return this.personneService.get
//    }
}
