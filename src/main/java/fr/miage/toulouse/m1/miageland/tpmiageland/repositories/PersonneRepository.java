package fr.miage.toulouse.m1.miageland.tpmiageland.repositories;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface  PersonneRepository extends CrudRepository<Personne, Long> {

    List<Personne> findByPrenomAndNom(String prenom, String nom);
    List<Personne> findByPrenom(String prenom);
    List<Personne> findByNom(String nom);
    Optional<Personne> findByAdresseMail(String adresseMail);

}
