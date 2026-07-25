package com.innovera.coursemanagementsystem.exception;

public class InstructorNotFoundException extends RuntimeException {

    public InstructorNotFoundException(Long id) {
        super("Instructor with id " + id + " not found.");
    }
}
