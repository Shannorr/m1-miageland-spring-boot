package fr.miage.toulouse.m1.miageland.tpmiageland.repositories;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BilletRepository extends CrudRepository<Billet, Long> {

    List<Billet> findBilletsByPersonne(Personne personne);
}
