package com.example.helloSpringBoot.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneDTO {

    @NotBlank(message = "手机品牌不可为空")
    private String model;

    @NotBlank(message = "手机名称不允许为空")
    private String phoneName;

    @Min(value = 1 , message = "金额需要大于0")
    private int price;

    @NotBlank(message = "库存不可以为空")
    private String stock;
}
