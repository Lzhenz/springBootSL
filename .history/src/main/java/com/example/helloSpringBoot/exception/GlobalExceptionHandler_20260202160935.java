
package com.example.helloSpringBoot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.helloSpringBoot.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 通用异常
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e){
        return Result.fail(e.getMessage());
    }

    // 捕捉参数校验异常
    public Result<
    
}