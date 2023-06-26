package com.SpringREST.studentCRUDdemo.entity;

public class Error {
    private String message;




    public Error() {
    }
    public Error(String message) {
        System.out.println("CONStruCTeR calling------------->>>>>>>>>>>");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
