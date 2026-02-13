package com.example.helloSpringBoot.common;

// TODO:这里为什么要使用,<T>
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code , String message , T data){

    }
}
