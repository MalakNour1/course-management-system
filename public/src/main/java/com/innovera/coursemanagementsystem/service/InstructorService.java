package com.innovera.coursemanagementsystem.service;

import com.innovera.coursemanagementsystem.dto.InstructorRequestDTO;
import com.innovera.coursemanagementsystem.dto.InstructorResponseDTO;

import java.util.List;

public interface InstructorService {

    InstructorResponseDTO createInstructor(InstructorRequestDTO dto);

    InstructorResponseDTO getInstructorById(Long id);

    List<InstructorResponseDTO> getAllInstructors();

    InstructorResponseDTO updateInstructor(Long id, InstructorRequestDTO dto);

    void deleteInstructor(Long id);
}