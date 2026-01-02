package com.revature.helpers;

public class JSONResponse {
    private String response;

    public JSONResponse(String s) {
        this.setResponse(s);
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
