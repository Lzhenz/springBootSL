
package com.example.helloSpringBoot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.helloSpringBoot.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public Result<String> handleException(Exception e){
        return Result.fail(e.getMessage());
    }
    
}