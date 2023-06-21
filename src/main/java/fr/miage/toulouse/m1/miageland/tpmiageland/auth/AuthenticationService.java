package fr.miage.toulouse.m1.miageland.tpmiageland.auth;


import fr.miage.toulouse.m1.miageland.tpmiageland.config.JwtService;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Personne;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.PersonneRepository;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.AdresseMailUtilise;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.ParcInexistant;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.PersonneInnexistante;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PersonneRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws AdresseMailUtilise {
        var user = Personne.builder()
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .adresseMail(request.getAdresseMail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getAdresseMail(),
                        request.getPassword()
                )
        );
        var user = repository.findByAdresseMail(request.getAdresseMail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
//        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public void deleteEmploye(Long idEmploye) {
        // on cherche l'employe
        final Optional<Personne> employeOptional = repository.findById(idEmploye);
        // si elle n'existe pas on lance une exception
        if(employeOptional.isEmpty()) {
            throw new PersonneInnexistante("L'attraction d'id " + idEmploye + " n'existe pas.");
        }
        // sinon, on passe à false
        repository.deleteById(idEmploye);

    }

    private void saveUserToken(Personne user, String jwtToken) {
    }

    private void revokeAllUserTokens(Personne user) {
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

    }
}
