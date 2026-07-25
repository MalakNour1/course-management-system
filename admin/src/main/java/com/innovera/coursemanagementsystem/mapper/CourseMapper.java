package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.CourseRequestDTO;
import com.innovera.coursemanagementsystem.dto.CourseResponseDTO;
import com.innovera.coursemanagementsystem.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "instructor", ignore = true)
    Course toEntity(CourseRequestDTO dto);

    @Mapping(source = "instructor.id", target = "instructorId")
    @Mapping(source = "instructor.name", target = "instructorName")
    CourseResponseDTO toResponseDTO(Course course);

    List<CourseResponseDTO> toResponseDTOList(List<Course> courses);

    @Mapping(target = "instructor", ignore = true)
    void updateEntityFromDto(CourseRequestDTO dto,
                             @MappingTarget Course course);
}