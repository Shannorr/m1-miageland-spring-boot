package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="attraction")
public class Attraction {
    /*Id de l'entité*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*nom de l'attraction*/
    private String nomA;

    /*attraction ouverte ou non*/
    private boolean estOuvert;

    @ManyToOne()
    @JsonIgnoreProperties("attractions")
    public Parc parc;
}
