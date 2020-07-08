package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;

public class IfPositiveQuestionType {
    private String type;
    private Range range;

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("range")
    public Range getRange() { return range; }
    @JsonProperty("range")
    public void setRange(Range value) { this.range = value; }
}