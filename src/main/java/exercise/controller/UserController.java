package exercise.controller;

import exercise.repository.UserRepository;
import exercise.model.User;
import exercise.service.UserValidator;
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
        if (userValidator.isValidUser(user)) {

            synchronized (userRepository) {
                if (!userRepository.exists(user)) {
                    userRepository.create(user);
                    return "SUCCESS - user created.";
                } else {
                    return "FAILURE - user already exists.";
                }
            }

        } else {
            return "FAILURE - invalid user data";
        }
    }

    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
