package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /*Id de l'entité*/
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*nom du role*/
    private String nomRole;

    /*Méthode pour afficher l'opération
     @return une représentation textuelle de l'opération*/
    @Override
    public String toString() {// attention aux cycles
        return "Role{" +"id=" + id +", Nom du role=" + nomRole +'}';}

}
