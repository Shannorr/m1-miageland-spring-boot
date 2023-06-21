package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Attraction;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.BilletRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ParcRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilletService {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final BilletRepository billetRepository;

    private final ParcRepository parcRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param billetRepo le bean repository à injecter
     */
    public BilletService(BilletRepository billetRepo, ParcRepository parcRepo) {
        this.billetRepository = billetRepo;
        this.parcRepository = parcRepo;
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
            throw new ParcInexistant("Le billet d'id " + idBillet + " n'existe pas.");
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

}
