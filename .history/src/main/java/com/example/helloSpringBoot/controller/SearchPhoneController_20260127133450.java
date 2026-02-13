package com.example.helloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.service.SearchPhoneService;

@RestController
public class SearchPhoneController {
    @Autowired
    private SearchPhoneService searchPhoneService;

    @GetMapping("/searchPhoneName")
    public String getSearchPhoneName(){
        // 调用service
try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        PhoneDTO phoneDTO = searchPhoneService.getPhoneNameOneTime("xiaomi");
        return phoneDTO.getPhoneName();
    }
}
