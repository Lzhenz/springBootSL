package com.example.helloSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.helloSpringBoot.common.Result;


@RestController
public class HelloController {
    
    @GetMapping("/hello" produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> sayHello() {
        return Result.success("Hello, Spring Boot!");
    }
}
