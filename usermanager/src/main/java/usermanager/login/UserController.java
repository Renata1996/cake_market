package usermanager.login;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import usermanager.services.UserService;
import usermanager.user.User;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "http://localhost:8881")
public class UserController {

    private static final String REGISTRATION = "/registration";

    @Setter
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:8881")
    @RequestMapping(value = REGISTRATION, method = RequestMethod.POST, produces = "application/json")
    public Boolean user(@RequestBody User user, Model model) {
        user.setEnabled(1);
        userService.saveUser(user);
        return true;
    }


    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public User showUser(@PathVariable String userName, Model model) {

        User user = userService.getUserByName(userName);
        return user;
    }
}