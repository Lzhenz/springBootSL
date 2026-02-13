package com.example.helloSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.common.Result;
import com.example.helloSpringBoot.service.SearchPhoneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/phoneData")
public class SearchPhoneController {
    
    private final SearchPhoneService searchPhoneService;

    public SearchPhoneController(SearchPhoneService searchPhoneService){
        this.searchPhoneService = searchPhoneService;
    }

    @Operation(summary = "查询手机的名称专名(测试)")
    @GetMapping("/searchPhoneName")
    public PhoneDTO getSearchPhoneName(@RequestParam String brand){
        // 调用service
        PhoneDTO phoneDTO = searchPhoneService.getPhoneNameOneTime(brand);
        return phoneDTO;
    }

    @Operation(summary = "查询手机的电池容量(测试)")
    @GetMapping("/battery")
    public PhoneDTO getBatteryNum(@RequestParam String brand){
        PhoneDTO phoneDTO = searchPhoneService.getBatteryNum(brand);
        return phoneDTO;
    }

    @Rest
    public Result<String> createPhoneModel(@Valid @RequestBody PhoneDTO phone){
        
    }
}
