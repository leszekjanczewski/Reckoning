package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
