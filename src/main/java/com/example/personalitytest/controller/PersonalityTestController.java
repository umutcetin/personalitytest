package com.example.personalitytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalitytest.dto.Answers;
import com.example.personalitytest.dto.PersonalityTestDTO;
import com.example.personalitytest.service.PersonalityTestService;
import com.example.personalitytest.service.ValidationException;
import com.example.personalitytest.util.FileExistsException;

@RestController
@RequestMapping("/personalitytest")
public class PersonalityTestController {
	
	@Autowired
	private PersonalityTestService personalityTestService;

	@GetMapping("/")
	public PersonalityTestDTO getTest() {
	    return personalityTestService.getPersonalityTest();
	}
	
	@PostMapping
	public ResponseEntity<?> saveAnswers(@RequestBody Answers answers) {
		try {
			personalityTestService.saveAnswers(answers);
		} catch (ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		} catch (FileExistsException e) {
			return new ResponseEntity<>("User has already answered questions.", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Answers are saved.", HttpStatus.OK);
	}

}

