package fr.miage.toulouse.m1.miageland.tpmiageland.repositories;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Attraction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {
    List<Attraction> findByNomA(String nomA);
    List<Attraction> findByEstOuvert(boolean estOuvert);

}
