package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;

public class Condition {
    private Predicate predicate;
    private IfPositive ifPositive;

    @JsonProperty("predicate")
    public Predicate getPredicate() { return predicate; }
    @JsonProperty("predicate")
    public void setPredicate(Predicate value) { this.predicate = value; }

    @JsonProperty("if_positive")
    public IfPositive getIfPositive() { return ifPositive; }
    @JsonProperty("if_positive")
    public void setIfPositive(IfPositive value) { this.ifPositive = value; }
}