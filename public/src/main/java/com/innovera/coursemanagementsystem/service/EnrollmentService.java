package com.innovera.coursemanagementsystem.service;

import com.innovera.coursemanagementsystem.dto.EnrollmentRequestDTO;
import com.innovera.coursemanagementsystem.dto.EnrollmentResponseDTO;

import java.util.List;

public interface EnrollmentService {

    EnrollmentResponseDTO enrollStudent(EnrollmentRequestDTO dto);

    List<EnrollmentResponseDTO> findByStudentId(Long studentId);

    List<EnrollmentResponseDTO> findByCourseId(Long courseId);

    void deleteEnrollment(Long id);
}