package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Client;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Compte;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ClientRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.CompteRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.BanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestClient {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CompteRepository compteRepository;

    @Autowired
    BanqueMetier banqueMetier;

    @GetMapping("/clients")
    public Iterable<Client> getListClts() {
        return this.clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client getUnClt (@PathVariable("id") Client client) {
        return client;
    }

    @PostMapping("/clients")
    public Client postClient(@RequestBody Client c) {
        return this.clientRepository.save(c);
    }

    @GetMapping("/comptes")
    public Iterable<Compte> getListCmptes() {
        return this.compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte getUnCmpte (@PathVariable("id") Compte compte) {
        return compte;
    }

    @PostMapping("/comptes")
    public Compte postUnCmpte(@RequestBody Compte c) {
        return this.banqueMetier.creerCompte(c.client, c);
    }
}