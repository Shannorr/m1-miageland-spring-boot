package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
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




}
