package com.innovera.coursemanagementsystem.Serviceimpl;

import com.innovera.coursemanagementsystem.dto.EnrollmentRequestDTO;
import com.innovera.coursemanagementsystem.dto.EnrollmentResponseDTO;
import com.innovera.coursemanagementsystem.entity.Course;
import com.innovera.coursemanagementsystem.entity.Enrollment;
import com.innovera.coursemanagementsystem.entity.Student;
import com.innovera.coursemanagementsystem.exception.DuplicateEnrollmentException;
import com.innovera.coursemanagementsystem.exception.EnrollmentClosedException;
import com.innovera.coursemanagementsystem.exception.EnrollmentNotFoundException;
import com.innovera.coursemanagementsystem.mapper.EnrollmentMapper;
import com.innovera.coursemanagementsystem.repository.EnrollmentRepository;
import com.innovera.coursemanagementsystem.service.CourseService;
import com.innovera.coursemanagementsystem.service.EnrollmentService;
import com.innovera.coursemanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 StudentService studentService,
                                 CourseService courseService, EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentMapper = enrollmentMapper;
    }

    @Override
    public EnrollmentResponseDTO enrollStudent(EnrollmentRequestDTO dto) {

        Long studentId = dto.getStudentId();
        Long courseId = dto.getCourseId();

        Student student = studentService.getStudentEntity(studentId);
        Course course = courseService.getCourseEntity(courseId);
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(course.getRegistrationStartTime())
                || now.isAfter(course.getRegistrationEndTime()))
        {
            throw new EnrollmentClosedException();
        }

        if (enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new DuplicateEnrollmentException();
        }

        Enrollment enrollment = enrollmentMapper.toEntity(dto);

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return enrollmentMapper.toResponseDTO(savedEnrollment);
    }

    @Override
    public List<EnrollmentResponseDTO> findByStudentId(Long studentId) {
        return enrollmentMapper.toResponseDTOList(
                enrollmentRepository.findByStudentId(studentId)
        );
    }

    @Override
    public List<EnrollmentResponseDTO> findByCourseId(Long courseId) {
        return enrollmentMapper.toResponseDTOList(
                enrollmentRepository.findByCourseId(courseId)
        );
    }

    @Override
    public void deleteEnrollment(Long id) {

        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));

        enrollmentRepository.delete(enrollment);
    }
}