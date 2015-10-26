package base.controller;

import base.repository.UserRepository;
import base.model.User;
import base.service.UserValidator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserValidator userValidator;
    @Resource
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String createUser(@RequestBody User user) {
        String response = null;
        if (userValidator.isValidUser(user)) {
            response = saveUser(user);
        } else {
            response = "FAILURE - invalid user name or password";
        }
        return response;
    }

    private String saveUser(User user) {
        synchronized (this.userRepository) {
            if (!userRepository.exists(user)) {
                userRepository.save(user);
                return "SUCCESS - user created.";
            } else {
                return "FAILURE - user already exists.";
            }
        }
    }

    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
