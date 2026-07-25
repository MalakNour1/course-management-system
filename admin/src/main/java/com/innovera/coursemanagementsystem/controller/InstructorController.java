package com.innovera.coursemanagementsystem.controller;

import com.innovera.coursemanagementsystem.dto.InstructorRequestDTO;
import com.innovera.coursemanagementsystem.dto.InstructorResponseDTO;
import com.innovera.coursemanagementsystem.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{id}")
    public InstructorResponseDTO getInstructor(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PostMapping
    public InstructorResponseDTO createInstructor(@RequestBody InstructorRequestDTO dto) {
        return instructorService.createInstructor(dto);
    }

    @PutMapping("/{id}")
    public InstructorResponseDTO updateInstructor(@PathVariable Long id,
                                                  @RequestBody InstructorRequestDTO dto) {
        return instructorService.updateInstructor(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }
}