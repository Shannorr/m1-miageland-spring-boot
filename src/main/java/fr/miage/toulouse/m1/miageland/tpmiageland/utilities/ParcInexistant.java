package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class ParcInexistant extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public ParcInexistant(String s) {
        super(s);
    }
}
