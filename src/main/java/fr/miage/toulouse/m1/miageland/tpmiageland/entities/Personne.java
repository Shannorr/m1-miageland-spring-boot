package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {

    /*Id de l'entité*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nom de la personne
     */
    @NotNull
    private String nom;

    /**
     * Prenom de la personne
     */
    @NotNull
    private String prenom;

    /**
     * Adresse mail de la personne
     */
    @NotNull
    @Email
    private String adresseMail;

    /** role de la personne au sein du parc */
    @ManyToOne(optional = false)
    private Role role;
}
