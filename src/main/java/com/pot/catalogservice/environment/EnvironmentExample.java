package com.pot.catalogservice.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "polar")
public class EnvironmentExample {

    private final Environment environment;
    @Value("${server.port}")
    private String serverPort;
    private String greeting;

    public EnvironmentExample(Environment environment) {
        this.environment = environment;
    }

    public String getServerPort() {
        return environment.getProperty("server.port");
    }

    public String getServerPortValue() {
        return serverPort;
    }

    public String getGreeting() {
        return greeting;
    }

    //setter обязателен через него yml внедряет настройки
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
