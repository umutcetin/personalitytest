package com.example.personalitytest.service;

import org.springframework.stereotype.Service;

import com.example.personalitytest.dao.PersonalityTestDAO;
import com.example.personalitytest.dao.PersonalityTestDAOImpl;
import com.example.personalitytest.dto.PersonalityTestDTO;

@Service
public class PersonalityTestService {
	
	public PersonalityTestDTO getPersonalityTest() {
		
		PersonalityTestDAO personalityTestDAO = new PersonalityTestDAOImpl();
		return personalityTestDAO.getPersonalityTest();
	}

}
