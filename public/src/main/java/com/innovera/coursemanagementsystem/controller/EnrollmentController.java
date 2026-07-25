package com.innovera.coursemanagementsystem.controller;

import com.innovera.coursemanagementsystem.dto.EnrollmentRequestDTO;
import com.innovera.coursemanagementsystem.dto.EnrollmentResponseDTO;
import com.innovera.coursemanagementsystem.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public EnrollmentResponseDTO enrollStudent(@RequestBody EnrollmentRequestDTO dto) {
        return enrollmentService.enrollStudent(dto);
    }

    @GetMapping("/student/{studentId}")
    public List<EnrollmentResponseDTO> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.findByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<EnrollmentResponseDTO> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.findByCourseId(courseId);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}