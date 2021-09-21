package com.informatica.hackathon.ShareKart.exception;

public class EmailValidator {

    public static void validateEmail(String email) throws InvalidRequestException {
        if (!org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email)) {
            throw new InvalidRequestException("Invalid Email with value : " + email);
        }
    }
}
