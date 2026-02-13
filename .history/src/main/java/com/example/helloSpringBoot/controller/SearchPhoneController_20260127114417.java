package com.example.helloSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchPhoneController {
    @GetMapping("/searchPhoneName")
    public String getSearchPhoneName(){
        
    }
}
