package com.example.helloSpringBoot.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO {

    @NotBlank(message = "")
    private String phoneName;
    private String batteryNum;
}
