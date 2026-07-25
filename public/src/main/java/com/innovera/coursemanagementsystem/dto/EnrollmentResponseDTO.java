package com.innovera.coursemanagementsystem.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDTO {

    private Long id;
    private Long studentId;
    private String studentName;
    private Long courseId;
    private String courseName;
}