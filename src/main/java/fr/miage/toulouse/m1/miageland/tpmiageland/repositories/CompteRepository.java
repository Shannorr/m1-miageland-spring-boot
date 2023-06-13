package fr.miage.toulouse.m1.miageland.tpmiageland.repositories;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Compte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends CrudRepository <Compte, Long>{
}

