package com.informatica.hackathon.ShareKart.exception.handler;

import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.exception.ResourceNotFoundException;
import com.informatica.hackathon.ShareKart.exception.ValidationErrorResponse;
import com.informatica.hackathon.ShareKart.exception.Violation;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidRequestException.class, ResourceNotFoundException.class,
            DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleApiException(Exception ex, WebRequest request) {
        ResponseEntity<Object> responseEntity = null;
        if (ex instanceof InvalidRequestException) {
            responseEntity = onInvalidRequestException((InvalidRequestException) ex, request);
        } else if (ex instanceof ResourceNotFoundException) {
            responseEntity = onResourceNotFoundException((ResourceNotFoundException) ex, request);
        } else if (ex instanceof DataIntegrityViolationException) {
            responseEntity = onDataIntegrityViolationException((DataIntegrityViolationException) ex, request);
        }
        return responseEntity;
    }


    private ResponseEntity<Object> onDataIntegrityViolationException(
            DataIntegrityViolationException e, WebRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(
                new Violation(((SQLIntegrityConstraintViolationException) ((ConstraintViolationException) e.getCause())
                        .getCause()).getMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> onInvalidRequestException(
            InvalidRequestException e, WebRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(
                new Violation(e.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> onResourceNotFoundException(
            ResourceNotFoundException e, WebRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation(
                String.format("%s not found with %s : '%s'", e.getResourceName(), e.getFieldName(),
                        e.getFieldValue())));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> handleAllOtherExceptions(Exception ex, WebRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(
                new Violation(ex.getMessage(), ExceptionUtils.getStackTrace(ex)));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
