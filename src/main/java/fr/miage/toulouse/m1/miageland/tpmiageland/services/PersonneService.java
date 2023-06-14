package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.RoleRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.RoleInexistant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository personneRepo;
    private final RoleRepository roleRepo;

    /**
     * Constructeur pour l'injection du bean repository
     * @param personneRepo le bean repository à injecter
     */
    public PersonneService(PersonneRepository personneRepo, RoleRepository roleRepo) {
        this.personneRepo = personneRepo;
        this.roleRepo = roleRepo;
    }

    /**
     * Demande la création d'une nouvelle personne
     * Si le parc existe déjà on le retourne
     * @param nom nom du parc
     * @return le nouveau parc ou l'ancien parc
     */
    public Personne creerPersonne(String nom, String prenom, String adresseMail, String roleName) throws RoleInexistant {
        List<Personne> personnes = personneRepo.findByAdresseMail(adresseMail);
        List<Role> roles = roleRepo.findRoleByNomRole(roleName);
        Personne personne;
        if(roles.isEmpty()) {
            throw new RoleInexistant("Le role " + roleName +  " n'existe pas.");
        }

        if (personnes.isEmpty()) {
            personne = new Personne();
            personne.setNom(nom);
            personne.setPrenom(prenom);
            personne.setAdresseMail(adresseMail);
            personne.setRole(roles.get(0));
            personne = personneRepo.save(personne);
        } else {
            personne =  personnes.get(0);
        }
        return personne;
    }
}
