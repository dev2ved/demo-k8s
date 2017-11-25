package com.hnexplore.demoservice.resource;

import com.hnexplore.demoservice.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    @RequestMapping(method = GET)
    public Greeting standardGreetingView() {
        return new Greeting("Kubernetes App Hello, World!");
    }

    @RequestMapping(value = "/creative", method = GET)
    public Greeting creativeGreetingView() {
        return new Greeting("What’s kickin’, little chicken?");
    }
}
