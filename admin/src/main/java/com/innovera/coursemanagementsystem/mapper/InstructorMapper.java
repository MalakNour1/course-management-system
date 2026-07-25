package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.InstructorRequestDTO;
import com.innovera.coursemanagementsystem.dto.InstructorResponseDTO;
import com.innovera.coursemanagementsystem.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    Instructor toEntity(InstructorRequestDTO dto);
    InstructorResponseDTO toResponseDTO(Instructor instructor);
    List<InstructorResponseDTO> toResponseDTOList(List<Instructor> instructors);
    void updateEntityFromDto(InstructorRequestDTO dto, @MappingTarget Instructor instructor);
}
