package com.informatica.hackathon.ShareKart.exception;

public class InputValidator {

    public static void validateEmail(String email) throws InvalidRequestException {
        if (!org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email)) {
            throw new InvalidRequestException("Invalid Email with value : " + email);
        }
    }
    public static void validateSearch(String search) throws InvalidRequestException {
        if (search.isEmpty()) {
            throw new InvalidRequestException("Invalid search : " + search);
        }
    }
}
