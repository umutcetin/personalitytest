package com.example.personalitytest.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
    SINGLE_CHOICE, SINGLE_CHOICE_CONDITIONAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case SINGLE_CHOICE: return "single_choice";
            case SINGLE_CHOICE_CONDITIONAL: return "single_choice_conditional";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("single_choice")) return SINGLE_CHOICE;
        if (value.equals("single_choice_conditional")) return SINGLE_CHOICE_CONDITIONAL;
        throw new IOException("Cannot deserialize Type");
    }
}