package com.innovera.coursemanagementsystem.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorResponseDTO {

    private Long id;
    private String name;
    private String email;
}