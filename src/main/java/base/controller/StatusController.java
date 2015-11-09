package base.controller;

import base.model.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * This is just a simple controller with a single method to check if the web-app is up and running.
 *
 * Quick test procedure:
 *
 * 1. mvn clean tomcat:run
 * 2. wget http://localhost:8080/exercise/rest/status
 */
@RestController
@RequestMapping("/status")
public class StatusController {

//    @RequestMapping(method = RequestMethod.GET)
//    public String status() {
//        return "I'm alive!";
//    }

    /**
     * This method returns Status in the format matching 'Accept' request header.
     * Accept: application/xml -> will result in xml response
     * Accept: application/json -> will result in json response
     * no Accept param specified will return json response (default is the first type on the list)
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    public Status getStatus() {
        return createStatus();
    }

    @RequestMapping(value = "/xml", method = RequestMethod.GET, produces = {"application/xml"})
    public Status getXMLStatus() {
        return createStatus();
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = {"application/json"})
    public Status getJSONStatus() {
        return createStatus();
    }

    private Status createStatus() {
        Status status = new Status();

        status.setCode("OK");
        status.setMessage("I'm alive!");

        return status;
    }
}
