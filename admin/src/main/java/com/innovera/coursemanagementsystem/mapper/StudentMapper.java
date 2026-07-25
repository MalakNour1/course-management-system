package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.StudentRequestDTO;
import com.innovera.coursemanagementsystem.dto.StudentResponseDTO;
import com.innovera.coursemanagementsystem.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequestDTO dto);

    StudentResponseDTO toResponseDTO(Student student);

    List<StudentResponseDTO> toResponseDTOList(List<Student> students);

    void updateEntityFromDto(StudentRequestDTO dto, @MappingTarget Student student);

}