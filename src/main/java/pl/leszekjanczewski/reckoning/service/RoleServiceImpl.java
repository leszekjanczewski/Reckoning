package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Role;
import pl.leszekjanczewski.reckoning.repository.RoleRepo;

import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
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
    public Role save(Role role) {
        return roleRepo.save(role);
    }
}
