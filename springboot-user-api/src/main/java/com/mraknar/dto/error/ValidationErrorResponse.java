package com.mraknar.dto.error;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse {

    private String message;
    private Map<String, List<String>> errors;

    public ValidationErrorResponse(String message, Map<String, List<String>> errors) {
        this.message = message;
        this.errors = errors;
    }
}
