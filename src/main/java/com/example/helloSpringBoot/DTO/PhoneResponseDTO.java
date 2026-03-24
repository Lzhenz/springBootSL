package com.example.helloSpringBoot.DTO;

import lombok.Data;

@Data
public class PhoneResponseDTO {
    private String model;
    
    private String phoneName;

    private int price;

    private String stock;
}
