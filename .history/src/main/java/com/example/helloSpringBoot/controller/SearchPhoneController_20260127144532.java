package com.example.helloSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.service.SearchPhoneService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class SearchPhoneController {
    
    private final SearchPhoneService searchPhoneService;

    public SearchPhoneController(SearchPhoneService searchPhoneService)

    @Operation(summary = "查询手机的名称专名(测试)")
    @GetMapping("/searchPhoneName")
    public String getSearchPhoneName(@RequestParam String brand){
        // 调用service
        PhoneDTO phoneDTO = searchPhoneService.getPhoneNameOneTime(brand);;
        return phoneDTO.getPhoneName();
    }
}
