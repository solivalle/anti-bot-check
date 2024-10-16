package com.bot.service.impl;

import com.bot.model.request.SumRequest;
import com.bot.model.response.QuestionResponse;
import com.bot.service.SumService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SumServiceImpl implements SumService {

    private final Set<QuestionResponse> responses;

    public SumServiceImpl(){
        responses = new HashSet<>();
    }

    @Override
    public boolean verifySum(SumRequest sumRequest) {

        if(!isAlreadyProcessed(sumRequest.getQuestionResponse()))
            throw new RuntimeException("Response hasn't been given yet");

        return sumRequest.getQuestionResponse().getN1() +
                sumRequest.getQuestionResponse().getN2() +
                sumRequest.getQuestionResponse().getN3() == sumRequest.getSum();
    }

    @Override
    public QuestionResponse getQuestion() {

        int n1 = ThreadLocalRandom.current().nextInt(0, 100);
        int n2 = ThreadLocalRandom.current().nextInt(0, 100);
        int n3 = ThreadLocalRandom.current().nextInt(0, 100);

        QuestionResponse questionResponse = QuestionResponse.build(n1, n2, n3);

        if(isAlreadyProcessed(questionResponse))
            return questionResponse;

        responses.add(questionResponse);
        return questionResponse;

    }

    private boolean isAlreadyProcessed(QuestionResponse questionResponse){
        return responses.stream().filter(o -> o.equals(questionResponse)).findFirst().orElse(null) != null;
    }
}
