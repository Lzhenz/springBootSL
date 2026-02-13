package com.example.helloSpringBoot.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneDTO {

    @NotBlank(message = "手机名称不能为空")
    private String phoneName;

    @Min(value = 1, )
    private String batteryNum;
}
