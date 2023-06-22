package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.ParcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcs")
public class RestParc {

    @Autowired
    ParcService parcService;

    @PostMapping //pour créer un parc
    public Parc postParc(@RequestBody Parc parc){
        return this.parcService.creerParc(parc.getNomP());
    }

    @GetMapping("/{id}") //pour dire je veux récupérer un parc
    public Parc getParcById(@PathVariable("id") Long idParc){
        return this.parcService.recupererParc(idParc);
    }

    @DeleteMapping("/{id}")
    public void deleteParc(@PathVariable("id") Long idParc) {
        this.parcService.supprimerParc(idParc);
    }

    @GetMapping//pour dire je veux récupérer tous les parcs
    public Iterable<Parc> getParcs(){
        return this.parcService.recupererParcs();
    }

    @PostMapping("/jaugeY/{id}") //pour créer une jauge
    public Parc PostJauge(@PathVariable("id") Long idParc){
        return this.parcService.instaurerJauge(idParc);
    }

    @PostMapping("/jaugeN/{id}") //pour créer une jauge
    public Parc ResetJauge(@PathVariable("id") Long idParc){
        return this.parcService.enleverJauge(idParc);
    }

}
