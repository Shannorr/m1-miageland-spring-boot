package fr.miage.toulouse.m1.miageland.tpmiageland.auth;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/registerGerant")
    public ResponseEntity<AuthenticationResponse> registerGerant(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerAll(request, Role.GERANT));
    }

    @PostMapping("/registerEmploye")
    public ResponseEntity<AuthenticationResponse> registerEmploye(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerAll(request, Role.EMPLOYE));
    }

    @PostMapping("/registerVisiteur")
    public ResponseEntity<AuthenticationResponse> registerVisiteur(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerAll(request, Role.VISITEUR));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
