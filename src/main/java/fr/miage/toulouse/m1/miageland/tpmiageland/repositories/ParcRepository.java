package fr.miage.toulouse.m1.miageland.tpmiageland.repositories;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParcRepository extends CrudRepository<Parc, Long> {
    List<Parc> findByNomP(String nomP);
}
