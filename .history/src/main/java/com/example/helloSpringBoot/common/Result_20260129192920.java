package com.example.helloSpringBoot.common;

// TODO:这里为什么要使用,<T>
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data){
        

    }

}
