package com.example.personalitytest.dao;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.personalitytest.dto.PersonalityTestDTO;
import com.example.personalitytest.dto.converters.PersonalityTestConverter;
import com.example.personalitytest.util.FileService;

@Component
public class PersonalityTestDAOImpl implements PersonalityTestDAO{
	@Autowired
	FileService fileService;
	@Override
	public PersonalityTestDTO getPersonalityTest() {

//		PersonalityTestDTO personalityTest = new PersonalityTestDTO();
//		personalityTest.setCategories(Arrays.asList(new String[]{"cat1", "cat2"}));
//		
//		QuestionTypeDTO qt1 = new QuestionTypeDTO();
//		qt1.setType("type1");
//		qt1.setOptions(Arrays.asList(new String[]{"op1", "op2"}));
//		
//		QuestionDTO q1 = new QuestionDTO();
//		q1.setCategory("cat1");
//		q1.setQuestion("q1");
//		q1.setQuestion_type(qt1);
//		
//		
//		QuestionTypeDTO qt2 = new QuestionTypeDTO();
//		qt2.setType("type2");
//		qt2.setOptions(Arrays.asList(new String[]{"op3", "op4"}));
//		
//		QuestionDTO q2 = new QuestionDTO();
//		q2.setCategory("cat2");
//		q2.setQuestion("q2");
//		q2.setQuestion_type(qt2);
//		
//		personalityTest.setQuestions(Arrays.asList(new QuestionDTO[]{q1, q2}));
		
		String jsonString = fileService.getResourceString("static/personality_test.json");
		try {
			return PersonalityTestConverter.fromJsonString(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		};
		return null;
	}
}
