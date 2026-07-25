package com.innovera.coursemanagementsystem.Serviceimpl;

import com.innovera.coursemanagementsystem.dto.CourseRequestDTO;
import com.innovera.coursemanagementsystem.dto.CourseResponseDTO;
import com.innovera.coursemanagementsystem.entity.Course;
import com.innovera.coursemanagementsystem.entity.Instructor;
import com.innovera.coursemanagementsystem.mapper.CourseMapper;
import com.innovera.coursemanagementsystem.repository.CourseRepository;
import com.innovera.coursemanagementsystem.repository.InstructorRepository;
import com.innovera.coursemanagementsystem.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository,
                             InstructorRepository instructorRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.courseMapper = courseMapper;
    }
    @Override
    public Course getCourseEntity(Long id) {
        return courseRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        validateRegistrationWindow(dto);
        Course course = courseMapper.toEntity(dto);

        if (dto.getInstructorId() != null) {

            Instructor instructor =
                    instructorRepository.findById(dto.getInstructorId())
                            .orElseThrow(() -> new RuntimeException("Instructor not found"));

            course.setInstructor(instructor);
        }
        Course saved = courseRepository.save(course);
        return courseMapper.toResponseDTO(saved);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        return courseMapper.toResponseDTO(getCourseEntity(id));
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseMapper.toResponseDTOList(
                courseRepository.findByDeletedFalse()
        );
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {
        validateRegistrationWindow(dto);

        Course course = getCourseEntity(id);
        courseMapper.updateEntityFromDto(dto, course);
        if (dto.getInstructorId() != null) {

            Instructor instructor = instructorRepository.findById(dto.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));

            course.setInstructor(instructor);

        } else {

            course.setInstructor(null);
        }
        Course updated = courseRepository.save(course);
        return courseMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = getCourseEntity(id);

        if (!course.isDeleted()) {
            course.setDeleted(true);
            courseRepository.save(course);
        }
    }

    @Override
    public List<CourseResponseDTO> getCoursesByInstructor(Long instructorId) {
        return courseMapper.toResponseDTOList(
                courseRepository.findByInstructorIdAndDeletedFalse(instructorId)
        );
    }

    private void validateRegistrationWindow(CourseRequestDTO dto) {

        if (dto.getRegistrationStartTime() == null ||
                dto.getRegistrationEndTime() == null) {
            throw new RuntimeException("Registration window is required.");
        }

        if (dto.getRegistrationStartTime()
                .isAfter(dto.getRegistrationEndTime())) {

            throw new RuntimeException(
                    "Registration start time must be before registration end time."
            );
        }
    }

}