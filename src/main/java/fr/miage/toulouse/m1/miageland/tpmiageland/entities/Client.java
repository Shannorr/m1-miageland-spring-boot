package fr.miage.toulouse.m1.miageland.tpmiageland.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    public Long id;

    public String nom;
    public String prenom;

    @OneToMany(mappedBy = "client")
    public List<Compte> comptes;
}

