package fr.miage.toulouse.m1.miageland.tpmiageland.services;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Client;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Compte;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.ClientRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BanqueMetierImpl implements BanqueMetier{
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CompteRepository compteRepository;

    @Override
    public Compte creerCompte(Client c, Compte cpt) {
        Optional<Client> cli = this.clientRepository.findById(c.getId());
        Client moncli = cli.get();
        cpt.setClient(moncli);
        return this.compteRepository.save(cpt);
    }

    @Override
    public void crediterCompte(Compte cpt, double somme) {
        cpt.setSolde(cpt.getSolde()+somme);
    }

    //    rajouter une exception si on veut pas que lke compte soit à découvert
    @Override
    public void debiterCompte(Compte cpt, double somme)  {
        cpt.setSolde(cpt.getSolde()-somme);
    }
}
