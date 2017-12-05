package user_manager.services;

import user_manager.entities.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
