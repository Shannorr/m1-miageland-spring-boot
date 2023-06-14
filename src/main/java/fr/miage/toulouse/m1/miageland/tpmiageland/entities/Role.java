package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="role")
public class Role {
    /*Id de l'entité*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    /*nom du role*/
    @NotNull
    private String nomRole;

}
