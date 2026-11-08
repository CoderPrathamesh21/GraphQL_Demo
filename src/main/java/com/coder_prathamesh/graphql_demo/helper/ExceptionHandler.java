package com.coder_prathamesh.graphql_demo.helper;

public class ExceptionHandler {

    public static RuntimeException throwResourceNotFoundException() {
        return new RuntimeException("Resource not found!!!");
    }
}
