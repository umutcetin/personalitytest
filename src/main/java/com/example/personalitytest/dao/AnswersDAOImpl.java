package com.example.personalitytest.dao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.dto.converters.AnswersConverter;
import com.example.personalitytest.util.FileExistsException;
import com.example.personalitytest.util.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class AnswersDAOImpl implements AnswersDAO {
	@Autowired
	FileService fileService;
	public void saveAnswers(Answers answers) throws JsonProcessingException, IOException, FileExistsException{
		fileService.saveToFile("answers/" + answers.getUsername(), AnswersConverter.toJsonString(answers));
	}
}
