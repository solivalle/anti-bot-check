package com.bot.service.impl;

import com.bot.model.request.SumRequest;
import com.bot.model.response.QuestionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumServiceImplTest {

    private SumServiceImpl sumService;

    @BeforeEach
    void setUp() {
        sumService = new SumServiceImpl();
    }

    @Test
    void testVerifySum_WhenResponseProcessed_ShouldReturnTrue() {
        QuestionResponse questionResponse = sumService.getQuestion();
        SumRequest sumRequest = new SumRequest();
        sumRequest.setQuestionResponse(questionResponse);
        sumRequest.setSum(questionResponse.getN1() + questionResponse.getN2() + questionResponse.getN3());

        assertTrue(sumService.verifySum(sumRequest));
    }

    @Test
    void testVerifySum_WhenResponseNotProcessed_ShouldThrowException() {
        QuestionResponse questionResponse = QuestionResponse.build(1, 2, 3);
        SumRequest sumRequest = new SumRequest();
        sumRequest.setQuestionResponse(questionResponse);
        sumRequest.setSum(6);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            sumService.verifySum(sumRequest);
        });

        assertEquals("Response hasn't been given yet", exception.getMessage());
    }

    @Test
    void testGetQuestion_ShouldReturnNewQuestion() {
        QuestionResponse questionResponse = sumService.getQuestion();
        assertNotNull(questionResponse);
        assertNotEquals(0, questionResponse.getN1());
        assertNotEquals(0, questionResponse.getN2());
        assertNotEquals(0, questionResponse.getN3());
    }

    @Test
    void testGetQuestion_ShouldNotReturnAlreadyProcessedQuestion() {
        QuestionResponse questionResponse = sumService.getQuestion();
        sumService.getQuestion(); // Call again to add a new question

        assertNotEquals(questionResponse, sumService.getQuestion());
    }

    @Test
    void testVerifySum_WithIncorrectSum_ShouldReturnFalse() {
        QuestionResponse questionResponse = sumService.getQuestion();
        SumRequest sumRequest = new SumRequest();
        sumRequest.setQuestionResponse(questionResponse);
        sumRequest.setSum(questionResponse.getN1() + questionResponse.getN2() + questionResponse.getN3() + 10);

        assertFalse(sumService.verifySum(sumRequest));
    }

}
