package com.example.helloSpringBoot.common;

import lombok.Data;

// TODO:这里为什么要使用,<T>
@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(){}

    public Result(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        Result<T> r = new Result<T>();
        r.code = 200;
        r.message = "success";
        r.data = data;

        return r;
    }

    public static <T> Result<T> fail(String message){
        Result<T> r = new Result<T>();
        r.code = 500;
        r.message = message;
        r.data = null;
        
        return r;
    }

}
