package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.User;

public interface UserService {
    User findUserByLogin(String login);
    void saveUser(User user);
}
