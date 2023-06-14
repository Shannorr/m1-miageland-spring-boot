package fr.miage.toulouse.m1.miageland.tpmiageland.services;

import fr.miage.toulouse.m1.miageland.tpmiageland.entities.Role;
import fr.miage.toulouse.m1.miageland.tpmiageland.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role creerRole(String nomRole) {
        List<Role> roles = this.roleRepository.findRoleByNomRole(nomRole);
        Role role;
        if (roles.isEmpty()) {
            role = new Role();
            role.setNomRole(nomRole);
            role = roleRepository.save(role);
        } else {
            role = roles.get(0);
        }
        return role;
    }
}
