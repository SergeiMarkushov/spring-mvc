package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringMvcApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringMvcApplication.class, args);
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringMvcApplication.class, args);

    }

}
