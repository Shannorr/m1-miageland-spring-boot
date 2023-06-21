package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class BilletDejaUtilise extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public BilletDejaUtilise(String s) {
        super(s);
    }
}
