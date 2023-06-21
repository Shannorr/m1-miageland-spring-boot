package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class AttractionInexistante extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public AttractionInexistante(String s) {
        super(s);
    }
}
