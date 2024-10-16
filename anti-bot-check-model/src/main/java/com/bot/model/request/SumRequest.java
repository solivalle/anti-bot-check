package com.bot.model.request;

import com.bot.model.response.QuestionResponse;

public class SumRequest {

    private int sum;
    private QuestionResponse questionResponse;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public QuestionResponse getQuestionResponse() {
        return questionResponse;
    }

    public void setQuestionResponse(QuestionResponse questionResponse) {
        this.questionResponse = questionResponse;
    }
}
