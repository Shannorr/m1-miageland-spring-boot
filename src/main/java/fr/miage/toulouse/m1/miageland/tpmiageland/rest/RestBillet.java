package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billets")
public class RestBillet {
    @Autowired
    BilletService billetService;

    @PostMapping //pour créer un billet
    public Billet postBillet(@RequestBody Billet billet){
        return this.billetService.creerBillet(billet);
    }

    @DeleteMapping("/{id}") //pour supprimer un billet
    public void deleteBillet(@PathVariable("id") Long idBillet){
        this.billetService.supprimerBillet(idBillet);
    }

    @GetMapping("/{id}") //pour dire je veux récupérer un billet
    public Billet getBilletById(@PathVariable("id") Long idBillet){
        return this.billetService.recupererBillet(idBillet);
    }

    @GetMapping//pour dire je veux récupérer tous les parcs
    public Iterable<Billet> getBillets(){
        return this.billetService.recupererBillets();
    }

}
