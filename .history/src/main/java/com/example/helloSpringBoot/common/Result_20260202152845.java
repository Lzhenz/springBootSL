package com.example.helloSpringBoot.common;

import lombok.Data;

// TODO:这里为什么要使用,<T>
@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data){
        Result<T> r = new Result<T>();
        r.code = 0;
        r.message = "success";
        r.data = data;

        return r;
    }

    public static <T> Result<T> fail(String message){
        Result<T> r = new Result<T>();
        r.code = -1;
        r.message = message;
        
        return r;
    }

}
