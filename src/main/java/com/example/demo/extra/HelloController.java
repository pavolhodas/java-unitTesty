package com.example.demo.extra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/")
    public String getHello() {
        return "Greetings from Spring Boot!";
    }


}
