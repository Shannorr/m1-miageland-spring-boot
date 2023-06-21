package fr.miage.toulouse.m1.miageland.tpmiageland.auth;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String prenom;
    private String nom;
    private String adresseMail;
    private String password;
    private Role role;
}
