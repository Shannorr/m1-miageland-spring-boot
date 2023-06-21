package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.BilletRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ParcRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletDejaUtilise;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.BilletNonAssocie;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EmployeService {

    private final BilletRepository billetRepository;

    public EmployeService(BilletRepository billetRepo) {
        this.billetRepository = billetRepo;
    }

    /**
     * Permet de récupérer les infos d'un billet
     * @param idBillet id du billet
     * @return infos du billet
     * @throws BilletInexistant s'il n'existe pas de billet avec cet id
     */
    public Billet scannerBillet(long idBillet) throws BilletInexistant, BilletNonAssocie, BilletDejaUtilise {
        // on cherche le billet
        final Optional<Billet> optionalBillet = billetRepository.findById(idBillet);
        // s'il n'existe pas on lance une exception
        if(optionalBillet.isEmpty()) {
            throw new BilletInexistant("Le billet d'id " + idBillet + " n'existe pas.");
        }

        if (optionalBillet.get().getPersonne() == null) {
            throw new BilletNonAssocie("Le billet n'est pas associé");
        } else if (optionalBillet.get().isEtat()) {
            throw new BilletDejaUtilise("Le billet est déjà utilisé, date : " + optionalBillet.get().getDateVisite() );
        }

        Billet b = optionalBillet.get();
        b.setDateVisite(new Date(System.currentTimeMillis()).toString());
        b.setEtat(true);

        // sinon, on renvoie les infos
        return billetRepository.save(b);
    }
}
