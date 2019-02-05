package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.leszekjanczewski.reckoning.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findClientByPhoneOrEmail(String phone, String email);
    Client findByClientId(Long id);
}
