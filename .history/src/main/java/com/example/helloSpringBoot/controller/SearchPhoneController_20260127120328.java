package com.example.helloSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.service.SearchPhoneService;

@RestController
public class SearchPhoneController {

    @GetMapping("/searchPhoneName")
    public String getSearchPhoneName(){
        // 调用service
        SearchPhoneService SearchPhoneService = new SearchPhoneService();
        return "xiaomi 17";
    }
}
