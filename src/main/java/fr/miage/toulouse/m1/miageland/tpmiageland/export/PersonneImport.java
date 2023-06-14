package fr.miage.toulouse.m1.miageland.tpmiageland.export;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonneImport {
    private String nom;
    private String prenom;
    private String adresseMail;
    private String nomRole;
}

