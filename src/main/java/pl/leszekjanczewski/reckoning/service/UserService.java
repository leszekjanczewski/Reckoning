package pl.leszekjanczewski.reckoning.service;

import pl.leszekjanczewski.reckoning.model.User;

import java.util.List;

public interface UserService {
    User findUserByLogin(String login);
    User saveUser(User user);
    User saveAdmin(User user);
    List<User> findAll();
    void deleteUser(User user);
}
