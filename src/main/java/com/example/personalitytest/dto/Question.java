package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;

public class Question {
    private String question;
    private Category category;
    private QuestionType questionType;

    @JsonProperty("question")
    public String getQuestion() { return question; }
    @JsonProperty("question")
    public void setQuestion(String value) { this.question = value; }

    @JsonProperty("category")
    public Category getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(Category value) { this.category = value; }

    @JsonProperty("question_type")
    public QuestionType getQuestionType() { return questionType; }
    @JsonProperty("question_type")
    public void setQuestionType(QuestionType value) { this.questionType = value; }
}