package com.innovera.coursemanagementsystem.controller;

import com.innovera.coursemanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;
import com.innovera.coursemanagementsystem.dto.StudentRequestDTO;
import com.innovera.coursemanagementsystem.dto.StudentResponseDTO;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(
            @RequestBody StudentRequestDTO dto,
            @PathVariable Long id) {

        return studentService.updateStudent(id, dto);
    }
}
