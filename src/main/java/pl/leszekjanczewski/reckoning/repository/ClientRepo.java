package pl.leszekjanczewski.reckoning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.leszekjanczewski.reckoning.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findClientByPhoneOrEmail(String phone, String email);
}
