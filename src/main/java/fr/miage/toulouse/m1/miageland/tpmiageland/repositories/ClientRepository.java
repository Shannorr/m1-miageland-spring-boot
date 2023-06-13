package fr.miage.toulouse.m1.miageland.tpmiageland.repositories;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> getClientByNom(String nom);
}