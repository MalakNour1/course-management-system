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

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto) {
        return studentService.createStudent(dto);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(
            @RequestBody StudentRequestDTO dto,
            @PathVariable Long id) {

        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
