package com.example.helloSpringBoot.service;

import com.example.helloSpringBoot.DTO.PhoneDTO;

public class SearchPhoneService {
    
    public PhoneDTO getPhoneNameOneTime(String brandName){
        PhoneDTO phoneDTO = new PhoneDTO();
        if (brandName.equals("xiaomi")) {
            phoneDTO.setPhoneName("xiaomi 17 utral");
        }

        return phoneDTO;
    }
}
