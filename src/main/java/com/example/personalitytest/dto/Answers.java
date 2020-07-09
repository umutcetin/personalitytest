package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Answers {
    private String username;
    private List<Answer> answers;

    @JsonProperty("username")
    public String getUsername() { return username; }
    @JsonProperty("username")
    public void setUsername(String value) { this.username = value; }

    @JsonProperty("answers")
    public List<Answer> getAnswers() { return answers; }
    @JsonProperty("answers")
    public void setAnswers(List<Answer> value) { this.answers = value; }
}