package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class BilletInexistant extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public BilletInexistant(String s) {
        super(s);
    }
}
