package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Role;
import pl.leszekjanczewski.reckoning.repository.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findRoleByRole(String role) {
        return roleRepo.findByRole(role);
    }

    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }
}
