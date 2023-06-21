package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="parc")
public class Parc {
    /*Id de l'entité*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*nom du parc*/
    private String nomP;

    /*jauge du parc*/
    private Integer jaugeP;

    @OneToMany(mappedBy="parc")
    @JsonIgnoreProperties("parc")
    public List<Attraction> attractions;

    @OneToMany(mappedBy="parc")
    public List<Billet> billets;

}
