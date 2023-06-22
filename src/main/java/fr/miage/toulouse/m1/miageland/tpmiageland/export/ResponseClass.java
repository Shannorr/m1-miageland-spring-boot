package fr.miage.toulouse.m1.miageland.tpmiageland.export;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseClass {
    /**
     * Message d'erreur
     */
    private final String message;
    /**
     * Type de l'exception
     */
    private final Object objet;
}
