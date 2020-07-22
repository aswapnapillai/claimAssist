package com.ibm.claim.assist.plivo.config.model;

public class PlivoProperty {
    String authId;
    String authToken;
    String answerUrl;
    String callerNo;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public static void init(String s, String s1) {
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl;
    }

    public String getCallerNo() {
        return callerNo;
    }

    public void setCallerNo(String callerNo) {
        this.callerNo = callerNo;
    }

    @Override
    public String toString() {
        return "PlivoProperty{" +
                "authId='" + authId + '\'' +
                ", authToken='" + authToken + '\'' +
                ", answerUrl='" + answerUrl + '\'' +
                ", callerNo='" + callerNo + '\'' +
                '}';
    }
}
