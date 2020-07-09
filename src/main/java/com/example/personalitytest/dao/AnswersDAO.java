package com.example.personalitytest.dao;

import java.io.IOException;

import com.example.personalitytest.dto.Answers;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AnswersDAO {
	   public void saveAnswers(Answers answers) throws JsonProcessingException, IOException;	   
}

