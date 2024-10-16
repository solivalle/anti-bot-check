package com.bot.controller;

import com.bot.model.request.SumRequest;
import com.bot.model.response.QuestionResponse;
import com.bot.model.response.SumResponse;
import com.bot.service.SumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification")
public class AntiBotCheckApi {

    private final SumService sumService;

    public AntiBotCheckApi(SumService sumService){
        this.sumService = sumService;
    }

    @GetMapping("/check")
    public ResponseEntity<SumResponse> verifyCheck(@RequestBody SumRequest sumRequest) {
        if(sumService.verifySum(sumRequest))
            return new ResponseEntity<>(SumResponse.build("good"), HttpStatus.OK);

        return new ResponseEntity<>(SumResponse.build("bad"), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/bot-test")
    public ResponseEntity<QuestionResponse> verifyCheck() {
        return new ResponseEntity<>(sumService.getQuestion(), HttpStatus.OK);
    }

}
