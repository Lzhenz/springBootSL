
package com.example.helloSpringBoot.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.helloSpringBoot.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public Result<String> handleException(Exception e){
        
    }
    
}