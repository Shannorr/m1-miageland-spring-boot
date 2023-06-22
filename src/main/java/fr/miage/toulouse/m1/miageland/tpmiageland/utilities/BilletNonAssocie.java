package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class BilletNonAssocie extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public BilletNonAssocie(String s) {
        super(s);
    }
}