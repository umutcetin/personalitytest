package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Predicate {
    private List<String> exactEquals;

    @JsonProperty("exactEquals")
    public List<String> getExactEquals() { return exactEquals; }
    @JsonProperty("exactEquals")
    public void setExactEquals(List<String> value) { this.exactEquals = value; }
}