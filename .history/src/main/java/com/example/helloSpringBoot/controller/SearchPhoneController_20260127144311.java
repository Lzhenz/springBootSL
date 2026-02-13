package com.example.helloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.service.SearchPhoneService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SearchPhoneController {
    @Autowired
    private SearchPhoneService searchPhoneService;

    @Operation(summary = "查询手机的名称专名(测试)")
    @GetMapping("/searchPhoneName")
    public String getSearchPhoneName(){
        // 调用service
        PhoneDTO phoneDTO = null;
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null != phoneDTO ? phoneDTO.getPhoneName() :"null data" ;
    }
}
