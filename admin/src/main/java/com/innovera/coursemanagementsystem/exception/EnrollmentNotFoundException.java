package com.innovera.coursemanagementsystem.exception;

public class EnrollmentNotFoundException extends RuntimeException {

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment with id " + id + " not found.");
    }
}