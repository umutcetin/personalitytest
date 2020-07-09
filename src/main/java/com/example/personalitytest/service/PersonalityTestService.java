package com.example.personalitytest.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.personalitytest.dao.AnswersDAO;
import com.example.personalitytest.dao.AnswersDAOImpl;
import com.example.personalitytest.dao.PersonalityTestDAO;
import com.example.personalitytest.dao.PersonalityTestDAOImpl;
import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.dto.PersonalityTestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PersonalityTestService {
	
	public PersonalityTestDTO getPersonalityTest() {
		
		PersonalityTestDAO personalityTestDAO = new PersonalityTestDAOImpl();
		return personalityTestDAO.getPersonalityTest();
	}

	public String saveAnswers(Answers answers) {
		
		//check input
		System.out.println(answers.getUsername());
		//save
		AnswersDAO answersDAO = new AnswersDAOImpl();
		try {
			answersDAO.saveAnswers(answers);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
