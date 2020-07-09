package com.example.personalitytest.dao;

import org.springframework.stereotype.Component;

import com.example.personalitytest.dto.PersonalityTestDTO;

@Component
public interface PersonalityTestDAO {
	   public PersonalityTestDTO getPersonalityTest();	   
}
