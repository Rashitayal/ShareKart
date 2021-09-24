package com.informatica.hackathon.ShareKart.exception;

public class InputValidator {

    public static void validateEmail(String email) throws InvalidRequestException {
        if (!org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email)) {
            throw new InvalidRequestException("Invalid Email with value : " + email);
        }
    }
    public static void validateString(String search) throws InvalidRequestException {
        if (search.isEmpty()) {
            throw new InvalidRequestException("Invalid search : " + search);
        }
    }

    public static void validateInteger(Integer id) throws InvalidRequestException {
        if (id == null) {
            throw new InvalidRequestException("Invalid Value of : " + id);
        }
    }
}
