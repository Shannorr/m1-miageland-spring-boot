package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class PersonneInnexistante extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public PersonneInnexistante(String s) {
        super(s);
    }
}
