package com.hnexplore.demoservice.resource;

import com.hnexplore.demoservice.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api_greeting")
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping(method = GET)
    public Greeting standardGreetingView() {
        LOGGER.info("ENTERED: Standard greeting");
        return new Greeting("Kubernetes App Hello, World!");
    }

    @RequestMapping(value = "/creative", method = GET)
    public Greeting creativeGreetingView() {
        LOGGER.info("ENTERED: Creative greeting");
        return new Greeting("What’s kickin’, little chicken?");
    }
}
