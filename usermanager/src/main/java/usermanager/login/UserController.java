package usermanager.login;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usermanager.services.UserService;
import usermanager.user.User;

@RestController
public class UserController {

    private static final String REGISTRATION = "/registration";

    @Setter
    @Autowired
    private UserService userService;

    @RequestMapping(REGISTRATION)
    public String user(@PathVariable User user) {
        userService.saveUser(user);
        return "ok";
    }
}
