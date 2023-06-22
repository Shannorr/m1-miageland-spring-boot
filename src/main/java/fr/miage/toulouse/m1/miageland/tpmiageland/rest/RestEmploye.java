package fr.miage.toulouse.m1.miageland.tpmiageland.rest;


import fr.miage.toulouse.m1.miageland.tpmiageland.auth.AuthenticationResponse;
import fr.miage.toulouse.m1.miageland.tpmiageland.auth.RegisterRequest;
import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Billet;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class RestEmploye {

    private final EmployeService employeService;

    @GetMapping("/{idBillet}")
    public Billet scannerBillet(
            @PathVariable("idBillet") Long idBillet
    ) {
        return employeService.scannerBillet(idBillet);
    }


}
