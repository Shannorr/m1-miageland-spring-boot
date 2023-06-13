package fr.miage.toulouse.m1.miageland.tpmiageland.services;


import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Client;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Compte;

public interface BanqueMetier {

    public Compte creerCompte(Client c, Compte cpt);
    public void crediterCompte(Compte cpt, double somme);
    public void debiterCompte(Compte cpt, double somme);
}
