package com.innovera.coursemanagementsystem.service;

import com.innovera.coursemanagementsystem.dto.CourseRequestDTO;
import com.innovera.coursemanagementsystem.dto.CourseResponseDTO;
import com.innovera.coursemanagementsystem.entity.Course;

import java.util.List;

public interface CourseService {

    Course getCourseEntity(Long id);

    CourseResponseDTO createCourse(CourseRequestDTO dto);

    CourseResponseDTO getCourseById(Long id);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto);

    void deleteCourse(Long id);

    List<CourseResponseDTO> getCoursesByInstructor(Long instructorId);
}