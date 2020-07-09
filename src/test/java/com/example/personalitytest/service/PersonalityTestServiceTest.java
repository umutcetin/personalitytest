package com.example.personalitytest.service;

import com.example.personalitytest.dao.AnswersDAO;
import com.example.personalitytest.dto.Answer;
import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.dto.Category;
import com.example.personalitytest.dto.Question;
import com.example.personalitytest.util.FileExistsException;
import com.example.personalitytest.util.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonalityTestServiceTest {

    @InjectMocks
    PersonalityTestService personalityTestService;

    @Mock
    FileService fileService;
    @Mock
    AnswersDAO answersDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testSaveAnswers_InputIsValid_DoesNotThrow() throws ValidationException, FileExistsException {
        Answers answers_success = new Answers();
        answers_success.setUsername("john.doe@doe.com");
        Answer answer = new Answer();
        answer.setQuestion("What is your gender?");
        answer.setCategory(Category.HARD_FACT);
        answer.setAnswer("male");
        answers_success.setAnswers(Arrays.asList(new Answer[]{answer}));

        when(fileService.fileExists(answers_success.getUsername())).thenReturn(false);

        assertDoesNotThrow(() -> personalityTestService.saveAnswers(answers_success));
    }

    @Test
    final void testSaveAnswers_AnswersNull_ThrowValidationException() throws ValidationException, FileExistsException {
        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(null));
    }

    @Test
    final void testSaveAnswers_UserNameIsEmptyString_ThrowValidationException() throws ValidationException, FileExistsException {
        Answers answers_emptyUser = new Answers();
        answers_emptyUser.setUsername("");
        Answer answer = new Answer();
        answer.setQuestion("What is your gender?");
        answer.setCategory(Category.HARD_FACT);
        answer.setAnswer("male");
        answers_emptyUser.setAnswers(Arrays.asList(new Answer[]{answer}));

        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(answers_emptyUser));
    }

    @Test
    final void testSaveAnswers_AnswerListIsNull_ThrowValidationException() throws ValidationException, FileExistsException {
        Answers answers_nullAnswerList = new Answers();
        answers_nullAnswerList.setUsername("john.doe@doe.com");

        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(answers_nullAnswerList));
    }

    @Test
    final void testSaveAnswers_AnswerListIsEmpty_ThrowValidationException() throws ValidationException, FileExistsException {
        Answers answers_emptyAnswerList = new Answers();
        answers_emptyAnswerList.setUsername("john.doe@doe.com");
        answers_emptyAnswerList.setAnswers(Arrays.asList(new Answer[]{}));

        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(answers_emptyAnswerList));
    }
}