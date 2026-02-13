
package com.example.helloSpringBoot.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.helloSpringBoot.common.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {



    // 捕捉参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleValidException(MethodArgumentNotValidException e){
        String msg = e.getBindingResult()
                      .getAllErrors()
                      .get(0)
                      .getDefaultMessage();
        return Result.fail(msg);
    }
    
}