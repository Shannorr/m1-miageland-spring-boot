package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Attraction;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.BilletRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ParcRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletDejaUtilise;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.PersonneInnexistante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilletService {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final BilletRepository billetRepository;
    private final PersonneRepository personneRepository;

    private final ParcRepository parcRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param billetRepo le bean repository à injecter
     */
    public BilletService(BilletRepository billetRepo, ParcRepository parcRepo, PersonneRepository personneRepository) {
        this.billetRepository = billetRepo;
        this.parcRepository = parcRepo;
        this.personneRepository = personneRepository;
    }

    /**
     * Demande la création d'un nouveau billet pour un parc
     * @param billet le billet
     * @return le billet
     */
    public Billet creerBillet(Billet billet) {
        //Opération métier
        Optional<Parc> parc = parcRepository.findById(billet.getParc().getId());
        if(parc.isEmpty()) {
            throw new ParcInexistant("Le parc d'id " + billet.getParc().getId() + " n'existe pas.");
        }
        Parc monParc = parc.get();
        Billet monBillet = new Billet();
        monBillet.setPrix(billet.getPrix());
        monBillet.setEtat(false);
        monBillet.setDateVisite(null);
        monBillet.setParc(monParc);
        monBillet = billetRepository.save(monBillet);
        monParc.billets.add(monBillet);
        parcRepository.save(monParc);
        // retourne le billet
        return monBillet;
    }

    /**
     * Supprime un billet d'un parc
     * @param id id du billet
     * @return le billet
     */
    public void supprimerBillet(Long id) {
        // on cherche le parc
        final Optional<Billet> optionalBillet = billetRepository.findById(id);
        // s'il n'existe pas on lance une exception
        if(optionalBillet.isEmpty()) {
            throw new BilletInexistant("Le billet d'id " + id + " n'existe pas.");
        }
        billetRepository.deleteById(id);
    }


    /**
     * Permet de récupérer les infos d'un billet
     * @param idBillet id du billet
     * @return infos du billet
     * @throws BilletInexistant s'il n'existe pas de billet avec cet id
     */
    public Billet recupererBillet(long idBillet) throws BilletInexistant {
        // on cherche le billet
        final Optional<Billet> optionalBillet = billetRepository.findById(idBillet);
        // s'il n'existe pas on lance une exception
        if(optionalBillet.isEmpty()) {
            throw new BilletInexistant("Le billet d'id " + idBillet + " n'existe pas.");
        }
        // sinon, on renvoie les infos
        return optionalBillet.get();
    }

    public Iterable<Billet> recupererBillets(){
        // on cherche les billets
        final Iterable<Billet> optionalBillet = billetRepository.findAll();
        //on renvoie les infos
        return optionalBillet;
    }

    public Iterable<Billet> recupererBilletsByIdPers(Long idPers) throws PersonneInnexistante{
        // on cherche la personne
        final Optional<Personne> optionalPersonne = personneRepository.findById(idPers);
        if (optionalPersonne.isEmpty()) {
            throw new PersonneInnexistante("Cette personne n'hexiste pas ");
        }
        Personne pers = optionalPersonne.get();
        // on cherche les billets
        final Iterable<Billet> optionalBillet = billetRepository.findBilletsByPersonne(pers);
        //on renvoie les infos
        return optionalBillet;
    }

    public Billet reserverBillet(Long idBillet, Long idPers) throws PersonneInnexistante, BilletDejaUtilise {
        Billet billet = this.recupererBillet(idBillet);

        // on cherche la personne
        final Optional<Personne> optionalPersonne = personneRepository.findById(idPers);
        if (optionalPersonne.isEmpty()) {
            throw new PersonneInnexistante("Cette personne n'hexiste pas ");
        }

        if (billet.getPersonne() != null) {
            throw new BilletDejaUtilise("Billet pris");
        }

        billet.setPersonne(optionalPersonne.get());
        return billetRepository.save(billet);

    }

    public Billet annulerReservation(Long idBillet, Long idPers) throws PersonneInnexistante {
        Billet billet = this.recupererBillet(idBillet);

        // on cherche la personne
        final Optional<Personne> optionalPersonne = personneRepository.findById(idPers);
        if (optionalPersonne.isEmpty()) {
            throw new PersonneInnexistante("Cette personne n'hexiste pas ");
        }
        billet.setPersonne(null);
        return billetRepository.save(billet);
    }

}
