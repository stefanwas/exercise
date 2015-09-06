package exercise.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    public void StatusController() {
        System.out.print("!!!STATUS");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String status() {
        return "I'm alive";
    }
}
