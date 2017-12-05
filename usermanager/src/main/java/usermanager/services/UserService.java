package usermanager.services;

import usermanager.entities.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
