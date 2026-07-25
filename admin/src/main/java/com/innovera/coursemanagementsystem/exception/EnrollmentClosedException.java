package com.innovera.coursemanagementsystem.exception;

public class EnrollmentClosedException extends RuntimeException {

    public EnrollmentClosedException() {
        super("Registration for this course is currently closed.");
    }
}
