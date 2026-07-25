package com.innovera.coursemanagementsystem.service;

import com.innovera.coursemanagementsystem.entity.Student;
import com.innovera.coursemanagementsystem.dto.StudentRequestDTO;
import com.innovera.coursemanagementsystem.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    Student getStudentEntity(Long id);

    StudentResponseDTO createStudent(StudentRequestDTO dto);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);

    StudentResponseDTO getStudentById(Long id);

    List<StudentResponseDTO> getAllStudents();

    void deleteStudent(Long id);

}
