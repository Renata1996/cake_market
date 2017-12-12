package usermanager.login;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import usermanager.services.UserService;
import usermanager.user.User;

@Controller
@RequestMapping("/uaa")
public class UserController {

    private static final String REGISTRATION = "/registration";

    @Setter
    @Autowired
    private UserService userService;

    @RequestMapping(value = REGISTRATION)
    public ModelAndView user() {
      //  userService.saveUser(user);
        ModelAndView modelAndView = new ModelAndView("registration");
        System.out.println("зашкл");
        return modelAndView;
    }
}
