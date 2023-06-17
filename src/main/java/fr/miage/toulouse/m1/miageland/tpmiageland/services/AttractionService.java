package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Attraction;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.AttractionRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ParcRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.AttractionInexistante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionService {
    /**
     * Bean repository qui sera injecté par le constructeur
     */
    private final AttractionRepository attractionRepository;
    private final ParcRepository parcRepository;

    /**
     * Constructeur pour l'injection du bean repository
     * @param attraRepo le bean repository à injecter
     */
    public AttractionService(AttractionRepository attraRepo, ParcRepository parcRepo) {
        this.attractionRepository = attraRepo;
        this.parcRepository = parcRepo;
    }

    /**
     * Demande la création d'une nouvelle attraction
     * Si l'attraction existe déjà on le retourne
     * @param nom nom de l'attraction
     * @return la nouvelle ou l'ancienne attraction
     */
    public Attraction creerAttraction(Parc p, String nom) {
        //Opération métier
        //On cherche si l'attraction est déjà présente
        List<Attraction> attractions = attractionRepository.findByNomA(nom);
        Attraction attraction;
        // si elle n'est pas présente
        if (attractions.isEmpty()) {
            // on la crée
            Optional<Parc> parc = parcRepository.findById(p.getId());
            Parc monParc = parc.get();
            attraction = new Attraction();
            attraction.setNomA(nom);
            attraction.setEstOuvert(true);
            attraction.setParc(monParc);
            attraction = attractionRepository.save(attraction);
            monParc.attractions.add(attraction);
            parcRepository.save(monParc);
        } else {
            // sinon, on retournera l'ancienne
            attraction = attractions.get(0);
        }
        // retourne le parc
        return attraction;
    }

    /**
     * Permet de récupérer les infos d'une attraction
     * @param idAttra id de l'attraction
     * @return infos de l'attraction
     * @throws AttractionInexistante s'il n'existe pas d'attraction avec cet id
     */
    public Attraction recupererAttraction(long idAttra) throws AttractionInexistante {
        // on cherche l'attraction
        final Optional<Attraction> optionalAttraction = attractionRepository.findById(idAttra);
        // si elle n'existe pas on lance une exception
        if(optionalAttraction.isEmpty()) {
            throw new AttractionInexistante("L'attraction d'id " + idAttra + " n'existe pas.");
        }
        // sinon, on renvoie les infos
        return optionalAttraction.get();
    }

    /**
     * Permet de récupérer les attractions ouvertes ou fermées
     * @param estOuvert attraction ouverte ou fermée
     * @return attractions ouvertes ou fermées
     */
    public Iterable<Attraction> recupererAttractionsByestOuvert(boolean estOuvert) {
        // on cherche l'attraction
        final Iterable<Attraction> optionalAttraction = attractionRepository.findByEstOuvert(estOuvert);
        // on renvoie les infos
        return optionalAttraction;
    }

    /**
     * Permet de récupérer les attractions
     * @return attractions
     **/
    public Iterable<Attraction> recupererAttractions(){
        // on cherche les attractions
        final Iterable<Attraction> optionalAttraction = attractionRepository.findAll();
        //on renvoie les infos
        return optionalAttraction;
    }

    /**
     * Permet de fermer une attraction
     * @param idAttra id de l'attraction
     * @return infos de l'attraction fermée
     * @throws AttractionInexistante s'il n'existe pas d'attraction avec cet id
     */
    public Attraction fermerAttraction(long idAttra) throws AttractionInexistante {
        // on cherche l'attraction
        final Optional<Attraction> optionalAttraction = attractionRepository.findById(idAttra);
        // si elle n'existe pas on lance une exception
        if(optionalAttraction.isEmpty()) {
            throw new AttractionInexistante("L'attraction d'id " + idAttra + " n'existe pas.");
        }
        // sinon, on passe à false
        Attraction attraction = optionalAttraction.get();
        attraction.setEstOuvert(false);
        attractionRepository.save(attraction);
        return attraction;
    }

    /**
     * Permet d'ouvrir une attraction
     * @param idAttra id de l'attraction
     * @return infos de l'attraction ouverte
     * @throws AttractionInexistante s'il n'existe pas d'attraction avec cet id
     */
    public Attraction ouvrirAttraction(long idAttra) throws AttractionInexistante {
        // on cherche l'attraction
        final Optional<Attraction> optionalAttraction = attractionRepository.findById(idAttra);
        // si elle n'existe pas on lance une exception
        if(optionalAttraction.isEmpty()) {
            throw new AttractionInexistante("L'attraction d'id " + idAttra + " n'existe pas.");
        }
        // sinon, on passe à false
        Attraction attraction = optionalAttraction.get();
        attraction.setEstOuvert(true);
        attractionRepository.save(attraction);
        return attraction;
    }

    /**
     * Permet de supprimer une attraction
     * @param idAttra id de l'attraction
     * @return l'attraction supprimée
     * @throws AttractionInexistante s'il n'existe pas d'attraction avec cet id
     */
    public void supAttraction(long idAttra) throws AttractionInexistante {
        // on cherche l'attraction
        final Optional<Attraction> optionalAttraction = attractionRepository.findById(idAttra);
        // si elle n'existe pas on lance une exception
        if(optionalAttraction.isEmpty()) {
            throw new AttractionInexistante("L'attraction d'id " + idAttra + " n'existe pas.");
        }
        // sinon, on passe à false
        attractionRepository.deleteById(idAttra);
    }
}
