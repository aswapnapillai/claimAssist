package com.ibm.claim.assist.plivo.config.model;

public class PlivoProperty {
    String authId;
    String authToken;

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

    @Override
    public String toString() {
        return "PlivoProperty{" +
                "authId='" + authId + '\'' +
                ", authToken='" + authToken + '\'' +
                '}';
    }
}
