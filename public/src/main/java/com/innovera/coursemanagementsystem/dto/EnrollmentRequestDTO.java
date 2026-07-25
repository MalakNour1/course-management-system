package com.innovera.coursemanagementsystem.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDTO {

    private Long studentId;
    private Long courseId;
}