package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.Role;

public interface RoleService {

    Role findRoleByRole(String role);
    void saveRole(Role role);

}
