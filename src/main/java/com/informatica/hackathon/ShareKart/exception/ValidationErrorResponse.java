package com.informatica.hackathon.ShareKart.exception;

import java.util.ArrayList;

public class ValidationErrorResponse {
    private ArrayList<Violation> violations = new ArrayList<>();

    public ArrayList<Violation> getViolations() {
        return violations;
    }

    public void setViolations(ArrayList<Violation> violations) {
        this.violations = violations;
    }
}
