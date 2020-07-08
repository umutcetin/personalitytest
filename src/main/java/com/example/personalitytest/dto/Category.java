package com.example.personalitytest.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Category {
    HARD_FACT, INTROVERSION, LIFESTYLE, PASSION;

    @JsonValue
    public String toValue() {
        switch (this) {
            case HARD_FACT: return "hard_fact";
            case INTROVERSION: return "introversion";
            case LIFESTYLE: return "lifestyle";
            case PASSION: return "passion";
        }
        return null;
    }

    @JsonCreator
    public static Category forValue(String value) throws IOException {
        if (value.equals("hard_fact")) return HARD_FACT;
        if (value.equals("introversion")) return INTROVERSION;
        if (value.equals("lifestyle")) return LIFESTYLE;
        if (value.equals("passion")) return PASSION;
        throw new IOException("Cannot deserialize Category");
    }
}