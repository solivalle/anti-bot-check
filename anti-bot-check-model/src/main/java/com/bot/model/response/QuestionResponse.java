package com.bot.model.response;

public class QuestionResponse {

    private String message = "please sum these 3 numbers";
    private int n1;
    private int n2;
    private int n3;

    public static QuestionResponse build(int n1, int n2, int n3){
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setN1(n1);
        questionResponse.setN2(n2);
        questionResponse.setN3(n3);
        return questionResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof QuestionResponse o){

            return o.getN1() == this.getN1() &&
                    o.getN2() == this.getN2() &&
                        o.getN3() == this.getN3();
        }

        return false;
    }
}
