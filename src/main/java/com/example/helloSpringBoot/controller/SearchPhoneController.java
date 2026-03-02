package com.example.helloSpringBoot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.DTO.PhoneResponseDTO;
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
<<<<<<< HEAD
    public List<PhoneModel> searchByPhoneName(@RequestParam String phoneName){
=======
    public List<PhoneResponseDTO> searchByPhoneName(@RequestParam String phoneName){
>>>>>>> 038a7af (统一返回接口)
        return phoneModelService.findByPhoneName(phoneName);
    }

    @Operation(summary = "按照品牌名称进行分页查询")
    @GetMapping("/getPageSearch")
<<<<<<< HEAD
    public Page<PhoneModel> pageSearchByModel(@RequestParam String model , @RequestParam int page , @RequestParam int size){
=======
    public Page<PhoneResponseDTO> pageSearchByModel(@RequestParam String model , @RequestParam int page , @RequestParam int size){
>>>>>>> 038a7af (统一返回接口)
        Pageable pageable = PageRequest.of(page, size , Sort.by("price").descending());
        return phoneModelService.findByModel(model , pageable);
    }

    @Operation(summary = "按照品牌名称和价格区间进行查询价格")
    @GetMapping("/getPageSearchByModelAndPrice")
<<<<<<< HEAD
    public Page<PhoneModel> pageSearchByModelAndPrince(@RequestParam String model, @RequestParam int page, @RequestParam int size,@RequestParam double minPrice, @RequestParam double maxPrice){
=======
    public Page<PhoneResponseDTO> pageSearchByModelAndPrince(@RequestParam String model, @RequestParam int page, @RequestParam int size,@RequestParam double minPrice, @RequestParam double maxPrice){
>>>>>>> 038a7af (统一返回接口)
        Pageable pageable = PageRequest.of(page, size);
        return phoneModelService.findByBrandAndPriceBetween(model, minPrice, maxPrice, pageable);
    }

<<<<<<< HEAD

=======
    @Operation(summary = "按照任意条件进行查询")
    @GetMapping("/getPageSearchByAnyCase")
    public Result<Page<PhoneResponseDTO>> pageSearchByAnyCase(@RequestParam String model, @RequestParam int page, @RequestParam int size,@RequestParam double minPrice, @RequestParam double maxPrice){
        Pageable pageable = PageRequest.of(page, size);
        Page<PhoneResponseDTO> pageResult = phoneModelService.search(model, minPrice, maxPrice, pageable);
        return Result.success(pageResult);
    }
>>>>>>> 038a7af (统一返回接口)
}   
