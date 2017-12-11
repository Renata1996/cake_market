package usermanager.services;

import usermanager.user.User;

public interface UserService {

    User getUserByName(String userName);

    void saveUser(User user);
}
