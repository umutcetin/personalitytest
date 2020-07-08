package com.example.personalitytest.dto;

import java.util.List;

public class PersonalityTestDTO {
	private List<String> categories;
	private List<QuestionDTO> questions;
	
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<QuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}
}
