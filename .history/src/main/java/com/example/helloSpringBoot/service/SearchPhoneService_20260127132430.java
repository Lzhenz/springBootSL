package com.example.helloSpringBoot.service;

import com.example.helloSpringBoot.DTO.PhoneDTO;

@Ser
public class SearchPhoneService {
    
    public PhoneDTO getPhoneNameOneTime(String brandName){
        PhoneDTO phoneDTO = new PhoneDTO();
        if (brandName.equals("xiaomi")) {
            phoneDTO.setPhoneName("xiaomi 17 utral");
        }else{
            phoneDTO.setPhoneName("unKnowBrand");
        }
        return phoneDTO;
    }
}
