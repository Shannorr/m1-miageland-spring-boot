package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ParcRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.ParcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestParc {

    @Autowired
    ParcService parcService;

    /*@GetMapping("/parcs") //pour dire je veux récupérer la liste des parcs
    public Iterable<Parc> getListParcs(){
        //return this.parcService.recupererParcs();
    }*/

    @PostMapping("/parcs") //pour créer un parc
    public Parc postParc(@RequestBody Parc parc){
        return this.parcService.creerParc(parc.getNomP());
    }

    @GetMapping("/parcs/{id}") //pour dire je veux récupérer un parc
    public Parc getParcById(@PathVariable("id") Long idParc){
        return this.parcService.recupererParc(idParc);
    }

    @GetMapping("/parcs") //pour dire je veux récupérer un parc
    public Iterable<Parc> getParcs(){
        return this.parcService.recupererParcs();
    }

}
