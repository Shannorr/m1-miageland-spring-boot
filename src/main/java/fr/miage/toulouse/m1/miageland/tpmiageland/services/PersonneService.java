package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.PasLesDroits;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.RoleInexistant;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    private final PersonneRepository personneRepo;

    /**
     * Constructeur pour l'injection du bean repository
     * @param personneRepo le bean repository à injecter
     */
    public PersonneService(PersonneRepository personneRepo) {
        this.personneRepo = personneRepo;
    }


    public void supprimerPersonne (Long id) throws ParcInexistant, PasLesDroits {
        // on cherche le parc
        final Optional<Personne> optionalPersonnnes  = personneRepo.findById(id);
        // s'il n'existe pas on lance une exception
        if(optionalPersonnnes.isEmpty()) {
            throw new ParcInexistant("La personne d'id " + id + " n'existe pas.");
        }
        Personne pers = optionalPersonnnes.get();
        if (pers.getRole() == Role.GERANT || pers.getRole() == Role.EMPLOYE) {
            throw new ParcInexistant("On ne peut pas supprimer un employe ou gerant en etant visiteur");
        }
        personneRepo.deleteById(id);
    }




}
