package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.export.PersonneImport;
import fr.miage.toulouse.m1.miageland.tpmiageland.export.Reservation;
import fr.miage.toulouse.m1.miageland.tpmiageland.export.ResponseClass;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.BilletService;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/visiteur")
public class RestVisiteur {

    @Autowired
    PersonneService personneService;

    @Autowired
    BilletService billetService;

    @DeleteMapping("/{id}")
    public void deleteParc(@PathVariable("id") Long idPers) {
        this.personneService.supprimerPersonne(idPers);
    }

    @GetMapping("/{id}/billets")
    public Iterable<Billet> getBilletByPers(
            @PathVariable("id") Long idPers
    ) {
        return this.billetService.recupererBilletsByIdPers(idPers);
    }

    @PutMapping("/billets")
    public Billet reserverBillet(
            @RequestBody Reservation res
            ) {
        return this.billetService.reserverBillet(res.getIdBillet(), res.getIdPers());
    }

    @PostMapping("/billets")
    public ResponseClass annulerReservation(
            @RequestBody Reservation res
    ) throws ParseException {
        return this.billetService.annulerReservation(res.getIdBillet(), res.getIdPers());
    }



}
