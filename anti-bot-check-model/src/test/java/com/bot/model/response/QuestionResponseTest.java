package com.bot.model.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionResponseTest {

    @Test
    void testBuild() {
        QuestionResponse response = QuestionResponse.build(1, 2, 3);
        assertNotNull(response);
        assertEquals(1, response.getN1());
        assertEquals(2, response.getN2());
        assertEquals(3, response.getN3());
        assertEquals("please sum these 3 numbers", response.getMessage());
    }

    @Test
    void testSetMessage() {
        QuestionResponse response = new QuestionResponse();
        response.setMessage("New message");
        assertEquals("New message", response.getMessage());
    }

    @Test
    void testSetN1() {
        QuestionResponse response = new QuestionResponse();
        response.setN1(10);
        assertEquals(10, response.getN1());
    }

    @Test
    void testSetN2() {
        QuestionResponse response = new QuestionResponse();
        response.setN2(20);
        assertEquals(20, response.getN2());
    }

    @Test
    void testSetN3() {
        QuestionResponse response = new QuestionResponse();
        response.setN3(30);
        assertEquals(30, response.getN3());
    }

    @Test
    void testEquals() {
        QuestionResponse response1 = QuestionResponse.build(1, 2, 3);
        QuestionResponse response2 = QuestionResponse.build(1, 2, 3);
        QuestionResponse response3 = QuestionResponse.build(4, 5, 6);

        assertEquals(response1, response2); // Should be equal
        assertNotEquals(response1, response3); // Should not be equal
        assertNotEquals(response2, response3); // Should not be equal
    }

    @Test
    void testEqualsWithDifferentObject() {
        Object obj = new Object();
        QuestionResponse response = QuestionResponse.build(1, 2, 3);

        assertNotEquals(response, obj); // Should not be equal
    }

}
