package com.example.helloSpringBoot.service;

import org.springframework.stereotype.Service;

import com.example.helloSpringBoot.DTO.PhoneDTO;

@Service
public class SearchPhoneService {
    
    public PhoneDTO getPhoneNameOneTime(String brandName){
        PhoneDTO phoneDTO = new PhoneDTO();
        if ("xiaomi".equals(brandName)) {
            phoneDTO.setPhoneName("xiaomi 17 utral");
        }else{
            phoneDTO.setPhoneName("unKnowBrand");
        }
        return phoneDTO;
    }

    public PhoneDTO getBatteryNum(String brandName){
        PhoneDTO phoneDTO = new PhoneDTO();
        if ("xiaomi".equals(brandName)) {
            phoneDTO.setBatteryNum("48000mha");
        }else{
            phoneDTO.setBatteryNum("unKnowBrand");
        }

        return 
    }
}
