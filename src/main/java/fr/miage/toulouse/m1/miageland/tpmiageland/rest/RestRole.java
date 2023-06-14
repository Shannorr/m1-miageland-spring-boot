package fr.miage.toulouse.m1.miageland.tpmiageland.rest;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import fr.miage.toulouse.m1.miageland.tpmiageland.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestRole {
    @Autowired
    RoleService roleService;

    public RestRole (RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/roles")
     public Role creerRole(@RequestBody Role role) { return this.roleService.creerRole(role.getNomRole()) ; }
}
