package com.example.personalitytest.dto;

import java.util.List;

public class QuestionTypeDTO {
	private String type;
	private List<String> options;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
}
