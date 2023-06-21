package fr.miage.toulouse.m1.miageland.tpmiageland.utilities;

public class RoleInexistant extends RuntimeException{
    /**
     * Constructeur
     * @param s message d'erreur
     */
    public RoleInexistant(String s) {
        super(s);
    }
}
