package exercise.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * This is just a simple web method to check if the web-app is up and running.
 *
 * Quick test procedure:
 *
 * 1. mvn clean tomcat:run
 * 2. open http://localhost:8080/exercise/rest/status
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @RequestMapping(method = RequestMethod.GET)
    public String status() {
        return "I'm alive!";
    }
}
