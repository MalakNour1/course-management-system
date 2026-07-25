package com.innovera.coursemanagementsystem.dto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {

    private Long id;
    private String name;
    private String description;
    private int creditHours;
    private Long instructorId;
    private String instructorName;
    private LocalDateTime registrationStartTime;
    private LocalDateTime registrationEndTime;
}