package com.example.personalitytest.dto;

import com.fasterxml.jackson.annotation.*;

public class Range {
    private long from;
    private long to;

    @JsonProperty("from")
    public long getFrom() { return from; }
    @JsonProperty("from")
    public void setFrom(long value) { this.from = value; }

    @JsonProperty("to")
    public long getTo() { return to; }
    @JsonProperty("to")
    public void setTo(long value) { this.to = value; }
}