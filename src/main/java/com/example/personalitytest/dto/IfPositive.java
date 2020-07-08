package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;

public class IfPositive {
    private String question;
    private Category category;
    private IfPositiveQuestionType questionType;

    @JsonProperty("question")
    public String getQuestion() { return question; }
    @JsonProperty("question")
    public void setQuestion(String value) { this.question = value; }

    @JsonProperty("category")
    public Category getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(Category value) { this.category = value; }

    @JsonProperty("question_type")
    public IfPositiveQuestionType getQuestionType() { return questionType; }
    @JsonProperty("question_type")
    public void setQuestionType(IfPositiveQuestionType value) { this.questionType = value; }
}