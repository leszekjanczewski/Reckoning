package pl.leszekjanczewski.reckoning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leszekjanczewski.reckoning.model.Client;
import pl.leszekjanczewski.reckoning.repository.ClientRepo;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client findClientByPhoneOrEmail(String phone, String email) throws NullPointerException {
        try {
            return clientRepo.findClientByPhoneOrEmail(phone, email);
        } catch (NullPointerException e) {
            return new Client();
        }
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepo.save(client);
    }
}
