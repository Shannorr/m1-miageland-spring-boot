package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Parc;

public interface BilletService {

    public Billet creerBillet(Parc p, Billet b);
    public void supprimerBillet(Parc p, Billet b);

}
