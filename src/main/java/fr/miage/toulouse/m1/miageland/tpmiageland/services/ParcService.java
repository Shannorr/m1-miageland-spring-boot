package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Attraction;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ParcRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParcService {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final ParcRepository parcRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param parcRepo le bean repository à injecter
     */
    public ParcService(ParcRepository parcRepo) {
        this.parcRepository = parcRepo;
    }

    /**
     * Demande la création d'un nouveau parc
     * Si le parc existe déjà on le retourne
     * @param nom nom du parc
     * @return le nouveau parc ou l'ancien parc
     */
    public Parc creerParc(String nom) {
        //Opération métier
        //On cherche si le parc est déjà présent
        List<Parc> parcs = parcRepository.findByNomP(nom);
        Parc parc;
        // s'il n'est pas présent
        if (parcs.isEmpty()) {
            // on le crée
            parc = new Parc();
            parc.setNomP(nom);
            parc = parcRepository.save(parc);
        } else {
            // sinon, on retournera l'ancien
            parc = parcs.get(0);
        }
        // retourne le parc
        return parc;
    }

    /**
     * Permet de récupérer les infos d'un parc
     * @param idParc id du parc
     * @return infos du parc
     * @throws ParcInexistant s'il n'existe pas de parc avec cet id
     */
    public Parc recupererParc(long idParc) throws ParcInexistant {
        // on cherche le parc
        final Optional<Parc> optionalParc = parcRepository.findById(idParc);
        System.out.println(idParc);
        // s'il n'existe pas on lance une exception
        if(optionalParc.isEmpty()) {
            throw new ParcInexistant("Le parc d'id " + idParc + " n'existe pas.");
        }
        // sinon, on renvoie les infos
        return optionalParc.get();
    }

    public Iterable<Parc> recupererParcs(){
        // on cherche les parcs
        final Iterable<Parc> optionalParc = parcRepository.findAll();
        //on renvoie les infos
        return optionalParc;
    }

    /**
     * Permet mettre une jauge à un parc
     * @param idParc id du parc
     * @return infos du parc
     * @throws ParcInexistant s'il n'existe pas de parc avec cet id
     */
    public Parc instaurerJauge(long idParc) throws ParcInexistant {
        // on cherche le parc
        final Optional<Parc> optionalParc = parcRepository.findById(idParc);
        // s'il n'existe pas on lance une exception
        if(optionalParc.isEmpty()) {
            throw new ParcInexistant("Le parc d'id " + idParc + " n'existe pas.");
        }
        // sinon, on renvoie les infos
        Parc monParc = optionalParc.get();
        List<Attraction> attractions = monParc.getAttractions();
        int nbAttraction = 0;
        for (Attraction a : attractions) {
            if(a.isEstOuvert())
                nbAttraction++;
        }
        monParc.setJaugeP(nbAttraction*25);
        return parcRepository.save(monParc);
    }

    /**
     * Permet d'enlever une jauge à un parc
     * @param idParc id du parc
     * @return infos du parc
     * @throws ParcInexistant s'il n'existe pas de parc avec cet id
     */
    public Parc enleverJauge(long idParc) throws ParcInexistant {
        // on cherche le parc
        final Optional<Parc> optionalParc = parcRepository.findById(idParc);
        // s'il n'existe pas on lance une exception
        if(optionalParc.isEmpty()) {
            throw new ParcInexistant("Le parc d'id " + idParc + " n'existe pas.");
        }
        // sinon, on renvoie les infos
        Parc monParc = optionalParc.get();
        monParc.setJaugeP(null);
        return parcRepository.save(monParc);
    }

}
