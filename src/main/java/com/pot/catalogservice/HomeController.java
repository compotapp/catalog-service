package com.pot.catalogservice;

import com.pot.catalogservice.environment.EnvironmentExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final EnvironmentExample environment;

    public HomeController(EnvironmentExample environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public String getGreeting() {
        return environment.getGreeting();
    }
}

