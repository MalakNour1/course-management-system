package com.innovera.coursemanagementsystem.dto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {

    private String name;
    private String description;
    private int creditHours;
    private Long instructorId;
    private LocalDateTime registrationStartTime;
    private LocalDateTime registrationEndTime;
}