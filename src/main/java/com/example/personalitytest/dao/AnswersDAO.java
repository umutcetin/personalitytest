package com.example.personalitytest.dao;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.util.FileExistsException;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public interface AnswersDAO {
	   public void saveAnswers(Answers answers) throws JsonProcessingException, IOException, FileExistsException;	   
}

