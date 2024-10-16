package com.bot.service;

import com.bot.model.request.SumRequest;
import com.bot.model.response.QuestionResponse;

public interface SumService {

    boolean verifySum(SumRequest sumRequest);

    QuestionResponse getQuestion();

}
