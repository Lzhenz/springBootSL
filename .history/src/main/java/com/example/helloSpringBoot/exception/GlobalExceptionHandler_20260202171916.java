
package com.example.helloSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.helloSpringBoot.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕捉参数校验异常
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleValidException(MethodArgumentNotValidException e){
        String msg = e.getBindingResult()
                      .getAllErrors()
                      .get(0)
                      .getDefaultMessage();
        return Result.fail(msg);
    }

    // 通用异常(通常在物理上写在后面)
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e){
        return Result.fail("系统异常，请稍后再试");
        // return Result.fail(e.getMessage());
    }
    
}