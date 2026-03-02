package com.example.helloSpringBoot.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
