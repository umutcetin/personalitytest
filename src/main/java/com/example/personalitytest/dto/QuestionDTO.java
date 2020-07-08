package com.example.personalitytest.dto;

public class QuestionDTO {
	private String category;
	private String question;
	private QuestionTypeDTO question_type;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public QuestionTypeDTO getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(QuestionTypeDTO question_type) {
		this.question_type = question_type;
	}
}
