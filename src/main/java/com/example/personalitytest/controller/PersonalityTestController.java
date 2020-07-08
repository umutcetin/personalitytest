package com.example.personalitytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalitytest.dto.PersonalityTestDTO;
import com.example.personalitytest.service.PersonalityTestService;

@RestController
@RequestMapping("/personalitytest")
public class PersonalityTestController {
	
	@Autowired
	private PersonalityTestService personalityTestService;

	@GetMapping("/")
	public PersonalityTestDTO getTest() {
	    return personalityTestService.getPersonalityTest();
	}
}
