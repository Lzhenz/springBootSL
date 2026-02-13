package com.example.helloSpringBoot.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneDTO {

    @Min(value = 1, message = "电池容量必须大于0")
    private int batteryNum;

    @NotBlank()
    private String phoneName;

}
