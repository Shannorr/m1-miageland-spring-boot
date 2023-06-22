package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Calendar;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="billet")
public class Billet {
    /*Id de l'entité*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numBillet;

    /*Date de la visite*/
    private Long dateVisite;

    /*Date de l'achat */
    private Long dateAchat;

    /*Prix du billet*/
    private double prix;

    /*Etat du billet*/
    private boolean etat;

    @ManyToOne()
    @JsonIgnoreProperties("billets")
    public Parc parc;

    @ManyToOne()
    @JsonIgnoreProperties("billets")
    public Personne personne;


}
