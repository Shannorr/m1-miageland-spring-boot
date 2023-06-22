package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class PasLesDroits extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public PasLesDroits(String s) {
        super(s);
    }
}