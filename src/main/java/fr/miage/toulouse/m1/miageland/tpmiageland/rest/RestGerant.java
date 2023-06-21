package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.auth.AuthenticationResponse;
import fr.miage.toulouse.m1.miageland.tpmiageland.auth.AuthenticationService;
import fr.miage.toulouse.m1.miageland.tpmiageland.auth.RegisterRequest;
import fr.miage.toulouse.m1.miageland.tpmiageland.export.ErrorExport;
import fr.miage.toulouse.m1.miageland.tpmiageland.utilities.AdresseMailUtilise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employes")
@RequiredArgsConstructor
public class RestGerant {

    private final AuthenticationService service;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> createEmploye(
            @RequestBody RegisterRequest request
            ) {
        return ResponseEntity.ok(service.register(request));
    }

    @DeleteMapping("/{id}")
    public ErrorExport deleteEmploye(
            @PathVariable("id") Long idEmploye
    ) {
       this.service.deleteEmploye(idEmploye);
       return new ErrorExport("delete employe", "200");
    }

}
