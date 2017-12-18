package usermanager.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usermanager.services.UserService;
import usermanager.user.User;

import java.security.Principal;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "http://localhost:8881")
public class UserController {

    private static final String REGISTRATION = "/registration";
    private static final String CROOSS_ORIGIN_PATH = "http://localhost:8881";
    private static final String TYPE = "application/json";
    private static final String SHOW_PATH = "/show/{id}";
    private static final String USER_PATH = "/user";

    @Setter
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = CROOSS_ORIGIN_PATH)
    @RequestMapping(value = REGISTRATION, method = RequestMethod.POST, produces = TYPE)
    public Boolean user(@RequestBody User user, Model model) {
        user.setEnabled(1);
        userService.saveUser(user);
        return true;
    }


    @RequestMapping(value = SHOW_PATH, method = RequestMethod.GET, produces = TYPE)
    public User showUser(@PathVariable String userName, Model model) {
        return userService.getUserByName(userName);
    }

    @RequestMapping(USER_PATH)
    public Principal user(Principal user) {
        return user;
    }
}