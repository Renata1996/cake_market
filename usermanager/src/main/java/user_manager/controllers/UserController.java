package user_manager.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import user_manager.entities.User;
import user_manager.services.SecurityService;
import user_manager.services.UserService;
import user_manager.validator.UserValidator;
import io.swagger.annotations.ApiOperation;

import javax.jws.soap.SOAPBinding;

@RestController
@RequestMapping("/user")
@Api(value = "onlinestore", description = "Operations pertaining to users in Online Store")
public class UserController {

    @Setter
    @Autowired
    private UserService userService;

    @Setter
    @Autowired
    private SecurityService securityService;

    @Setter
    @Autowired
    private UserValidator userValidator;


    @ApiOperation(value = "Add a user")
    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity registration(@RequestBody User user) {
       // userValidator.validate(user);
        userService.save(user);
        securityService.autologin(user.getUsername(), user.getPasswordConfirm());
        return new ResponseEntity("User save successfully", HttpStatus.OK);
    }


    @ApiOperation(value = "get a user", response = User.class)
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity  login(@PathVariable String login, @PathVariable String password) {
      userService.findByUsername(login);
        return new ResponseEntity("User logged in successfully", HttpStatus.OK);
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET, produces = "application/json")
    public String welcome(Model model) {
        return "welcome";
    }
}


