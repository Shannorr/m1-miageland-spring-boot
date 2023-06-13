package fr.miage.toulouse.m1.miageland.tpmiageland.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compte {
    @Id
    public Long id;

    public Double solde;

    @ManyToOne
    @JsonIgnoreProperties("comptes")
    public Client client;
}
