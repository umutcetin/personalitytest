package com.example.personalitytest.dao;

import java.io.IOException;

import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.dto.converters.AnswersConverter;
import com.example.personalitytest.util.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AnswersDAOImpl implements AnswersDAO {
	public void saveAnswers(Answers answers) throws JsonProcessingException, IOException{
		new FileService().saveToFile("answers/" + answers.getUsername(), AnswersConverter.toJsonString(answers));
	}
}
