package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.EnrollmentRequestDTO;
import com.innovera.coursemanagementsystem.dto.EnrollmentResponseDTO;
import com.innovera.coursemanagementsystem.entity.Course;
import com.innovera.coursemanagementsystem.entity.Enrollment;
import com.innovera.coursemanagementsystem.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-25T03:07:30+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

    @Override
    public Enrollment toEntity(EnrollmentRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Enrollment enrollment = new Enrollment();

        return enrollment;
    }

    @Override
    public EnrollmentResponseDTO toResponseDTO(Enrollment enrollment) {
        if ( enrollment == null ) {
            return null;
        }

        EnrollmentResponseDTO enrollmentResponseDTO = new EnrollmentResponseDTO();

        enrollmentResponseDTO.setStudentId( enrollmentStudentId( enrollment ) );
        enrollmentResponseDTO.setStudentName( enrollmentStudentName( enrollment ) );
        enrollmentResponseDTO.setCourseId( enrollmentCourseId( enrollment ) );
        enrollmentResponseDTO.setCourseName( enrollmentCourseName( enrollment ) );
        enrollmentResponseDTO.setId( enrollment.getId() );

        return enrollmentResponseDTO;
    }

    @Override
    public List<EnrollmentResponseDTO> toResponseDTOList(List<Enrollment> enrollments) {
        if ( enrollments == null ) {
            return null;
        }

        List<EnrollmentResponseDTO> list = new ArrayList<EnrollmentResponseDTO>( enrollments.size() );
        for ( Enrollment enrollment : enrollments ) {
            list.add( toResponseDTO( enrollment ) );
        }

        return list;
    }

    private Long enrollmentStudentId(Enrollment enrollment) {
        Student student = enrollment.getStudent();
        if ( student == null ) {
            return null;
        }
        return student.getId();
    }

    private String enrollmentStudentName(Enrollment enrollment) {
        Student student = enrollment.getStudent();
        if ( student == null ) {
            return null;
        }
        return student.getName();
    }

    private Long enrollmentCourseId(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getId();
    }

    private String enrollmentCourseName(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        if ( course == null ) {
            return null;
        }
        return course.getName();
    }
}
