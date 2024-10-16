package com.bot;

import com.bot.controller.AntiBotCheckApi;
import com.bot.model.request.SumRequest;
import com.bot.model.response.QuestionResponse;
import com.bot.model.response.SumResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SpringTest {

    @Autowired
    private AntiBotCheckApi antiBotCheckApi;

    @Test
    public void checkDependencyControl(){
        Assert.assertNotNull(antiBotCheckApi);
    }

    @Test
    public void getTest(){
        ResponseEntity<QuestionResponse> question = antiBotCheckApi.verifyCheck();
        Assert.assertNotNull(question);
        Assert.assertEquals(question.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void responseNotProcessedYet(){
        SumRequest sumRequest = generateSumRequest(1,2,3,6);
        Assert.assertThrows(RuntimeException.class, () -> antiBotCheckApi.verifyCheck(sumRequest));
    }

    @Test
    public void invalidSum(){
        ResponseEntity<QuestionResponse> question = antiBotCheckApi.verifyCheck();
        SumRequest sumRequest = generateSumRequest(question.getBody(), question.getBody().getN1());

        ResponseEntity<SumResponse> response = antiBotCheckApi.verifyCheck(sumRequest);

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);

    }

    @Test
    public void validSum(){
        ResponseEntity<QuestionResponse> question = antiBotCheckApi.verifyCheck();
        SumRequest sumRequest = generateSumRequest(question.getBody(), question.getBody().getN1() + question.getBody().getN3() + question.getBody().getN2());

        ResponseEntity<SumResponse> response = antiBotCheckApi.verifyCheck(sumRequest);

        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    private SumRequest generateSumRequest(Integer n1, Integer n2, Integer n3, Integer sum){
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setN1(n1);
        questionResponse.setN2(n2);
        questionResponse.setN3(n3);

        return generateSumRequest(questionResponse, sum);
    }

    private SumRequest generateSumRequest(QuestionResponse questionResponse, Integer sum){
        SumRequest sumRequest = new SumRequest();
        sumRequest.setSum(sum);
        sumRequest.setQuestionResponse(questionResponse);
        return sumRequest;
    }

}
