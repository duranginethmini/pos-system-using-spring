package com.example.posbackendusingspringframework.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException (){}
    public OrderNotFoundException (String message) {}
    public OrderNotFoundException (String message,Throwable cause ) {}
}
