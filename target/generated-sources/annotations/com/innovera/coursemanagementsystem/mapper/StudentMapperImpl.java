package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.StudentRequestDTO;
import com.innovera.coursemanagementsystem.dto.StudentResponseDTO;
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
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( dto.getName() );
        student.setEmail( dto.getEmail() );

        return student;
    }

    @Override
    public StudentResponseDTO toResponseDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId( student.getId() );
        studentResponseDTO.setName( student.getName() );
        studentResponseDTO.setEmail( student.getEmail() );

        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> toResponseDTOList(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentResponseDTO> list = new ArrayList<StudentResponseDTO>( students.size() );
        for ( Student student : students ) {
            list.add( toResponseDTO( student ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(StudentRequestDTO dto, Student student) {
        if ( dto == null ) {
            return;
        }

        student.setName( dto.getName() );
        student.setEmail( dto.getEmail() );
    }
}
