package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class PersonalityTestDTO {
    private List<Category> categories;
    private List<Question> questions;

    @JsonProperty("categories")
    public List<Category> getCategories() { return categories; }
    @JsonProperty("categories")
    public void setCategories(List<Category> value) { this.categories = value; }

    @JsonProperty("questions")
    public List<Question> getQuestions() { return questions; }
    @JsonProperty("questions")
    public void setQuestions(List<Question> value) { this.questions = value; }
}