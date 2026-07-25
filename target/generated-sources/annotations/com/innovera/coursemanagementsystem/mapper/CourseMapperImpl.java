package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.CourseRequestDTO;
import com.innovera.coursemanagementsystem.dto.CourseResponseDTO;
import com.innovera.coursemanagementsystem.entity.Course;
import com.innovera.coursemanagementsystem.entity.Instructor;
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
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toEntity(CourseRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        course.setName( dto.getName() );
        course.setDescription( dto.getDescription() );
        course.setCreditHours( dto.getCreditHours() );
        course.setRegistrationStartTime( dto.getRegistrationStartTime() );
        course.setRegistrationEndTime( dto.getRegistrationEndTime() );

        return course;
    }

    @Override
    public CourseResponseDTO toResponseDTO(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();

        courseResponseDTO.setInstructorId( courseInstructorId( course ) );
        courseResponseDTO.setInstructorName( courseInstructorName( course ) );
        courseResponseDTO.setId( course.getId() );
        courseResponseDTO.setName( course.getName() );
        courseResponseDTO.setDescription( course.getDescription() );
        courseResponseDTO.setCreditHours( course.getCreditHours() );
        courseResponseDTO.setRegistrationStartTime( course.getRegistrationStartTime() );
        courseResponseDTO.setRegistrationEndTime( course.getRegistrationEndTime() );

        return courseResponseDTO;
    }

    @Override
    public List<CourseResponseDTO> toResponseDTOList(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseResponseDTO> list = new ArrayList<CourseResponseDTO>( courses.size() );
        for ( Course course : courses ) {
            list.add( toResponseDTO( course ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(CourseRequestDTO dto, Course course) {
        if ( dto == null ) {
            return;
        }

        course.setName( dto.getName() );
        course.setDescription( dto.getDescription() );
        course.setCreditHours( dto.getCreditHours() );
        course.setRegistrationStartTime( dto.getRegistrationStartTime() );
        course.setRegistrationEndTime( dto.getRegistrationEndTime() );
    }

    private Long courseInstructorId(Course course) {
        Instructor instructor = course.getInstructor();
        if ( instructor == null ) {
            return null;
        }
        return instructor.getId();
    }

    private String courseInstructorName(Course course) {
        Instructor instructor = course.getInstructor();
        if ( instructor == null ) {
            return null;
        }
        return instructor.getName();
    }
}
