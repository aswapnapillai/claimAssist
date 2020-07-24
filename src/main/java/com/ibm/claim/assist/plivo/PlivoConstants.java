package com.ibm.claim.assist.plivo;

public enum PlivoConstants {

    smsMsg("Hello this is IBM's Claim Assist, this is a reminder to  claim your CATS/ILC at the earliest.");
    String data;
    PlivoConstants(String s) {
        data=s;
    }
    public String getData(){
        return data;
    }
}
