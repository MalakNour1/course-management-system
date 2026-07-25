package com.innovera.coursemanagementsystem.exception;

public class DuplicateEnrollmentException extends RuntimeException {

    public DuplicateEnrollmentException() {
        super("Student is already enrolled in this course.");
    }
}