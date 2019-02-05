package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.Role;

public interface RoleService {

    Role findRoleByRole(String role);
    Role save(Role role);
}
