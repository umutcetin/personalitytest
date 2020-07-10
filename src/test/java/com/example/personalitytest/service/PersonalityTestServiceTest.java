package com.example.personalitytest.service;

import com.example.personalitytest.dao.AnswersDAO;
import com.example.personalitytest.dao.PersonalityTestDAO;
import com.example.personalitytest.dto.*;
import com.example.personalitytest.util.FileExistsException;
import com.example.personalitytest.util.FileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class PersonalityTestServiceTest {

    @InjectMocks
    PersonalityTestService personalityTestService;

    @Mock
    FileService fileService;
    @Mock
    AnswersDAO answersDAO;
    @Mock
    PersonalityTestDAO personalityTestDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testGetPersonalityTest() throws Exception {
        PersonalityTestDTO personalityTestDTO = new PersonalityTestDTO();
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

        when(personalityTestDAO.getPersonalityTest()).thenReturn(personalityTestDTO);

        PersonalityTestDTO result;
        result = personalityTestService.getPersonalityTest();
        assertNotNull(result);
        assertEquals(personalityTestDTO.getQuestions().get(0).getCategory(), result.getQuestions().get(0).getCategory());
        assertTrue(personalityTestDTO.getCategories().size() == result.getCategories().size());
        assertTrue(personalityTestDTO.getQuestions().size() == result.getQuestions().size());

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
    final void testSaveAnswers_FileExists_ThrowFileExistsException() throws ValidationException, FileExistsException {
        Answers answers_existing = new Answers();
        answers_existing.setUsername("john.doe@doe.com");
        Answer answer = new Answer();
        answer.setQuestion("What is your gender?");
        answer.setCategory(Category.HARD_FACT);
        answer.setAnswer("male");
        answers_existing.setAnswers(Arrays.asList(new Answer[]{answer}));

        when(fileService.fileExists(anyString())).thenReturn(true);

        assertThrows(FileExistsException.class,
                () -> personalityTestService.saveAnswers(answers_existing));
    }

    @Test
    final void testSaveAnswers_AnswersNull_ThrowValidationException() throws ValidationException, FileExistsException {
        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(null));
    }

    @Test
    final void testSaveAnswers_UserNameIsEmptyString_ThrowValidationException() throws ValidationException,
            FileExistsException {
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
    final void testSaveAnswers_AnswerListIsNull_ThrowValidationException() throws ValidationException,
            FileExistsException {
        Answers answers_nullAnswerList = new Answers();
        answers_nullAnswerList.setUsername("john.doe@doe.com");

        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(answers_nullAnswerList));
    }

    @Test
    final void testSaveAnswers_AnswerListIsEmpty_ThrowValidationException() throws ValidationException,
            FileExistsException {
        Answers answers_emptyAnswerList = new Answers();
        answers_emptyAnswerList.setUsername("john.doe@doe.com");
        answers_emptyAnswerList.setAnswers(Arrays.asList(new Answer[]{}));

        assertThrows(ValidationException.class,
                () -> personalityTestService.saveAnswers(answers_emptyAnswerList));
    }
}