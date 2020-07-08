package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class QuestionType {
    private Type type;
    private List<String> options;
    private Condition condition;

    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }

    @JsonProperty("options")
    public List<String> getOptions() { return options; }
    @JsonProperty("options")
    public void setOptions(List<String> value) { this.options = value; }

    @JsonProperty("condition")
    public Condition getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(Condition value) { this.condition = value; }
}