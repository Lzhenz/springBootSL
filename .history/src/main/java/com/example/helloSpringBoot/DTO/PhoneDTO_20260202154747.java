package com.example.helloSpringBoot.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO {

    @Not
    private String phoneName;
    private String batteryNum;
}
