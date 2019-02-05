package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.Client;

public interface ClientService {
    Client findClientByPhoneOrEmail(String phone, String email);
    Client saveClient(Client client);
}
