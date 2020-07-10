package com.example.personalitytest.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personalitytest.dao.AnswersDAO;
import com.example.personalitytest.dao.PersonalityTestDAO;
import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.dto.PersonalityTestDTO;
import com.example.personalitytest.util.FileExistsException;
import com.example.personalitytest.util.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;


@Service
public class PersonalityTestService {

	@Autowired
	PersonalityTestDAO personalityTestDAO;
	@Autowired
	AnswersDAO answersDAO;
	@Autowired
	FileService fileService;

	public PersonalityTestDTO getPersonalityTest() {
		return personalityTestDAO.getPersonalityTest();
	}

	public String saveAnswers(Answers answers) throws ValidationException, FileExistsException {
		checkInput(answers);
		if (fileService.fileExists("answers/" + answers.getUsername())) {
			throw new FileExistsException("File already exists.");
		}
		try {
			answersDAO.saveAnswers(answers);
		} catch (JsonProcessingException e) {
			throw new ValidationException("Invalid input.");
		} catch (IOException e) {
			throw new ValidationException("File error.");
		}
		return null;
	}

	private void checkInput(Answers answers) throws ValidationException {
		if (answers == null) {
			throw new ValidationException("Invalid input.");
		}
		if (answers.getUsername() == null || answers.getUsername() == "") {
			throw new ValidationException("Invalid username.");
		}
		if (answers.getAnswers() == null || answers.getAnswers().size() == 0) {
			throw new ValidationException("Answers are empty.");
		}
	}

}
