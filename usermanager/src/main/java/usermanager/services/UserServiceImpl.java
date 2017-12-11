package usermanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import usermanager.repositories.AuthoritiRepository;
import usermanager.repositories.UserRepository;
import usermanager.user.Authorities;
import usermanager.user.User;

@Component
public class UserServiceImpl implements UserService {

    private static final String ROLE_USER = "ROLE_USER";

    private UserRepository userRepository;
    private AuthoritiRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthoritiRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getUserByName(String userName) {
        User user = userRepository.findUserByUsername(userName);
        return user;
    }

    @Override
    public void saveUser(User user) {
        Authorities role = new Authorities();
        role.setUserName(user.getUsername());
        role.setAuthority(ROLE_USER);
        roleRepository.save(role);
        userRepository.save(user);

    }
}
