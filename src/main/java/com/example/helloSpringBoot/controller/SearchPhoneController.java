package com.example.helloSpringBoot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.common.Result;
import com.example.helloSpringBoot.entity.PhoneModel;
import com.example.helloSpringBoot.service.PhoneModelService;
import com.example.helloSpringBoot.service.PhoneService;
import com.example.helloSpringBoot.service.SearchPhoneService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/phoneData")
public class SearchPhoneController {
    
    private final SearchPhoneService searchPhoneService;
    private final PhoneService phoneService;
    private final PhoneModelService phoneModelService;

    public SearchPhoneController(SearchPhoneService searchPhoneService , PhoneService phoneService , PhoneModelService phoneModelService){
        this.searchPhoneService = searchPhoneService;
        this.phoneService = phoneService;
        this.phoneModelService = phoneModelService;
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

    @Operation(summary = "新建手机型号(测试)")
    @PostMapping("/createPhoneModel")
    public Result<String> createPhoneModel(@Valid @RequestBody PhoneDTO phone){
        phoneService.create(phone);
        return Result.success("ok");
    }

    @Operation(summary = "从数据库查询一条完整的数据")
    public PhoneDTO searchOnePhoneData(@RequestParam Long phoneId){
        PhoneDTO phoneDTO = phoneService.searchOneDataByName(phoneId);
        return phoneDTO;
    }

    @Operation(summary = "按照phoneName进行查询数据,")
    @PostMapping("/getByPhoneName")
    public List<PhoneModel> searchByPhoneName(@RequestParam String phoneName){
        return phoneModelService.findByPhoneName(phoneName);
    }
}   
