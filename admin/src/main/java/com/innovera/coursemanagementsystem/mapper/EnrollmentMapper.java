package com.innovera.coursemanagementsystem.mapper;
import com.innovera.coursemanagementsystem.dto.EnrollmentRequestDTO;
import com.innovera.coursemanagementsystem.dto.EnrollmentResponseDTO;
import com.innovera.coursemanagementsystem.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "id", ignore = true)
    Enrollment toEntity(EnrollmentRequestDTO dto);

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "student.name", target = "studentName")
    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "course.name", target = "courseName")
    EnrollmentResponseDTO toResponseDTO(Enrollment enrollment);

    List<EnrollmentResponseDTO> toResponseDTOList(List<Enrollment> enrollments);
}
