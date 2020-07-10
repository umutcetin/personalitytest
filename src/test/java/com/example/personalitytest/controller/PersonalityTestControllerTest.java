package com.example.personalitytest.controller;

import com.example.personalitytest.dto.*;
import com.example.personalitytest.service.PersonalityTestService;
import com.example.personalitytest.service.ValidationException;
import com.example.personalitytest.util.FileExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class PersonalityTestControllerTest {

	@InjectMocks
	PersonalityTestController personalityTestController;
	
	@Mock
    PersonalityTestService personalityTestService;

	PersonalityTestDTO personalityTestDTO;

	@BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        personalityTestDTO = new PersonalityTestDTO();
        personalityTestDTO.setCategories(Arrays.asList(new Category[]{Category.HARD_FACT, Category.INTROVERSION}));

        Question q1 = new Question();
        q1.setCategory(Category.HARD_FACT);
        q1.setQuestion("What is your gender?");
        QuestionType qt1 = new QuestionType();
        qt1.setType(Type.SINGLE_CHOICE);
        qt1.setOptions(Arrays.asList(new String[]{"male", "female", "other"}));
        q1.setQuestionType(qt1);

        Question q2 = new Question();
        q2.setCategory(Category.HARD_FACT);
        q2.setQuestion("How important is the gender of your partner?");
        QuestionType qt2 = new QuestionType();
        qt2.setType(Type.SINGLE_CHOICE);
        qt2.setOptions(Arrays.asList(new String[]{"not important", "important", "very important"}));
        q2.setQuestionType(qt2);

        personalityTestDTO.setQuestions(Arrays.asList(new Question[]{q1, q2}));
    }

    @Test
    final void testGetTest(){
	    when(personalityTestService.getPersonalityTest()).thenReturn(personalityTestDTO);

	    PersonalityTestDTO result = personalityTestController.getTest();

	    assertNotNull(result);
	    assertEquals(personalityTestDTO.getQuestions().get(0).getCategory(), result.getQuestions().get(0).getCategory());
        assertTrue(personalityTestDTO.getCategories().size() == result.getCategories().size());
	    assertTrue(personalityTestDTO.getQuestions().size() == result.getQuestions().size());
	}

    @Test
    final void testSaveAnswers_InputIsValid_StatusOK(){
        Answers answers_success = new Answers();
        answers_success.setUsername("john.doe@doe.com");
        Answer answer = new Answer();
        answer.setQuestion("What is your gender?");
        answer.setCategory(Category.HARD_FACT);
        answer.setAnswer("male");
        answers_success.setAnswers(Arrays.asList(new Answer[]{answer}));

        ResponseEntity<?> result = personalityTestController.saveAnswers(answers_success);

        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    final void testSaveAnswers_InputIsInvalid_Status406() throws ValidationException, FileExistsException {
        when(personalityTestService.saveAnswers(any())).thenThrow(ValidationException.class);

        ResponseEntity<?> result = personalityTestController.saveAnswers(null);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, result.getStatusCode());
    }

    @Test
    final void testSaveAnswers_FileExists_Status400() throws ValidationException, FileExistsException {
        when(personalityTestService.saveAnswers(any())).thenThrow(FileExistsException.class);

        ResponseEntity<?> result = personalityTestController.saveAnswers(null);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
	
}
