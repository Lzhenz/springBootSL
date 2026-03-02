package com.example.helloSpringBoot.DTO;

<<<<<<< HEAD
public class PhoneResponseDTO {
    private String model;
    
    
=======
import lombok.Data;

@Data
public class PhoneResponseDTO {
    private String model;
    
    private String phoneName;

    private int price;

    private String stock;
>>>>>>> 038a7af (统一返回接口)
}
