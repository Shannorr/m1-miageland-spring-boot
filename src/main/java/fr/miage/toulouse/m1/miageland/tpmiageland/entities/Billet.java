package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

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
public class Billet {

    /*Id de l'entité*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numBillet;

    /*Date de la visite*/
    private Calendar dateVisite;

    /*Prix du billet*/
    private double prix;

    /*Etat du billet*/
    private boolean etat;

    /*Méthode pour afficher l'opération
     @return une représentation textuelle de l'opération*/
    @Override
    public String toString() {// attention aux cycles
        return "Billet{" +", numBillet=" + numBillet +", date de la visite=" + dateVisite +", prix du billet=" + prix +", État du billet=" + etat +'}';
    }

}
