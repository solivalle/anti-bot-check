package com.bot.model.response;

public class SumResponse {

    private String message;

    public static SumResponse build(String message){
        SumResponse sumResponse = new SumResponse();
        sumResponse.setMessage(message);
        return sumResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
