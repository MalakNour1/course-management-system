package com.innovera.coursemanagementsystem.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
}