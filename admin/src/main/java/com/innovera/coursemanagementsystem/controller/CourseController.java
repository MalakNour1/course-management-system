package com.innovera.coursemanagementsystem.controller;

import com.innovera.coursemanagementsystem.dto.CourseRequestDTO;
import com.innovera.coursemanagementsystem.dto.CourseResponseDTO;
import com.innovera.coursemanagementsystem.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseResponseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<CourseResponseDTO> getCoursesByInstructor(@PathVariable Long instructorId) {
        return courseService.getCoursesByInstructor(instructorId);
    }

    @PostMapping
    public CourseResponseDTO createCourse(@RequestBody CourseRequestDTO dto) {
        return courseService.createCourse(dto);
    }

    @PutMapping("/{id}")
    public CourseResponseDTO updateCourse(@PathVariable Long id,
                                          @RequestBody CourseRequestDTO dto) {
        return courseService.updateCourse(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}