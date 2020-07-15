package com.ibm.claim.assist.plivo;

public enum PlivoConstants {
    smsMsg("Please clock you CATS for the Week");
    String data;
    PlivoConstants(String s) {
        data=s;
    }
    public String getData(){
        return data;
    }
}
