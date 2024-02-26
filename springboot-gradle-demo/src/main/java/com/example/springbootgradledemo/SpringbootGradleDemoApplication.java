package com.example.springbootgradledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootGradleDemoApplication {
    @RequestMapping("/")
    String home() {
        return "Hello SpringBoot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGradleDemoApplication.class, args);
    }

}
