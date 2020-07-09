package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;

public class Answer {
    private String question;
    private String answer;
    private Category category;

    @JsonProperty("question")
    public String getQuestion() { return question; }
    @JsonProperty("question")
    public void setQuestion(String value) { this.question = value; }

    @JsonProperty("answer")
    public String getAnswer() { return answer; }
    @JsonProperty("answer")
    public void setAnswer(String value) { this.answer = value; }

    @JsonProperty("category")
    public Category getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(Category value) { this.category = value; }
}